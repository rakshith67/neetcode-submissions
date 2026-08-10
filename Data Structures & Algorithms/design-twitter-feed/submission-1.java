class Twitter {

    Map<Integer, User> usersMap;
    private static int timestamp = 0;

    public Twitter() {
        usersMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!usersMap.containsKey(userId)) {
            User user = new User(userId);
            usersMap.put(userId, user);
        }
        User user = usersMap.get(userId);
        user.post(tweetId, timestamp);
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        User user = usersMap.get(userId);
        if (user == null) {
            return result;
        }
        PriorityQueue<Tweet> queue = new PriorityQueue<>((tweet1, tweet2) -> 
            tweet2.timestamp - tweet1.timestamp);
        
        for (Integer following: user.following) {
            if (usersMap.containsKey(following)) {
                User current = usersMap.get(following);
                if (current.tweetHead != null) {
                    queue.offer(current.tweetHead);
                }
            }
        }

        int i = 0;
        while (!queue.isEmpty() && i < 10) {
            Tweet polled = queue.poll();
            result.add(polled.id);
            if (polled.next != null) {
                queue.offer(polled.next);
            }
            i++;
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            usersMap.put(followeeId, user);
        }
        if (!usersMap.containsKey(followerId)) {
            User user = new User(followerId);
            usersMap.put(followerId, user);
        }
        usersMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!usersMap.containsKey(followeeId) || !usersMap.containsKey(followerId)) {
            return;
        }
        User user = usersMap.get(followerId);
		user.unfollow(followeeId);
    }
}

class Tweet {
    public int id;
	public Tweet next;
	public int timestamp;
}

class User {
    public int id;
    public Set<Integer> following;
    Tweet tweetHead;

    public User(int id) {
        this.id = id;
        following = new HashSet<>();
        following.add(id);
        tweetHead = null;
    }

    public void follow(Integer userId) {
        following.add(userId);
    }

    public void unfollow(Integer userId) {
        if (userId != id) {
            following.remove(userId);
        }
    }

    public void post(int tweetId, int timestamp) {
        Tweet head = new Tweet();
		head.id = tweetId;
		head.timestamp = timestamp;
		head.next = tweetHead;
		tweetHead = head;
    }
}
