class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;
        int boats = 0;
        while (low <= high) {
            if (low == high) {
                boats++;
                break;
            }
            int sum = people[low] + people[high];
            if (sum <= limit) {
                boats++;
                low++;
                high--;
            } else {
                high--;
                boats++;
            }
        }
        return boats;
    }
}