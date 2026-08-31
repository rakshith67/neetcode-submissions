class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < length; i++) {
            map.put(position[i], speed[i]);
        }

        double previousTime = 0;
        int carFleet = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int pos = entry.getKey();
            int spd = entry.getValue();
            double time = (double) (target - pos) / spd;
            if (time > previousTime) {
                carFleet++;
                previousTime = time;
            }
        }
        return carFleet;
    }
}
