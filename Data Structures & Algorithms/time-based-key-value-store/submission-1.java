class TimeMap {

    Map<String, TreeMap<Integer, String>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!kvStore.containsKey(key)) {
            kvStore.put(key, new TreeMap<>());
        }
        TreeMap<Integer, String> treeMap = kvStore.get(key);
        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!kvStore.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = kvStore.get(key);
        return treeMap.floorEntry(timestamp) != null 
                    ? treeMap.floorEntry(timestamp).getValue()
                    : "";
    }
}
