class MyHashMap {
    int[] dp;
    public MyHashMap() {
        dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
    }
    
    public void put(int key, int value) {
        dp[key] = value;
    }
    
    public int get(int key) {
        return dp[key] != Integer.MAX_VALUE ? dp[key] : -1;
    }
    
    public void remove(int key) {
        dp[key] = Integer.MAX_VALUE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */