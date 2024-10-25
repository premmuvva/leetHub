class LRUCache {

    Map<Integer, Integer> hm ;
    int n;
    public LRUCache(int capacity) {
        hm = new LinkedHashMap<Integer, Integer>() {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
        n = capacity;
    }
    
    public int get(int key) {
        int ans = hm.getOrDefault(key, -1);
        if (ans != -1) {
            hm.remove(key);
            hm.put(key, ans);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            hm.remove(key);
        }
        hm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */