class TimeMap {

    Map<String, List<Pair<Integer, String>>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!kvStore.containsKey(key)) {
            kvStore.put(key, new ArrayList<>());
        }
        List<Pair<Integer, String>> list = kvStore.get(key);
        list.add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = kvStore.getOrDefault(key, new ArrayList<>());
        int low = 0;
        int high = values.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = (low + high) / 2;
            Pair<Integer, String> pair = values.get(mid);
            if (pair.getKey() <= timestamp) {
                result = pair.getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static class Pair<Integer, String> {
        private final Integer key;
        private final String value;

        public Pair(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
