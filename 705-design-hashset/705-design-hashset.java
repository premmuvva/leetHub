class MyHashSet {

    // int arr[];
    BitSet bs;
    public MyHashSet() {
        // arr = new int[1000001];
        bs = new BitSet();
    }
    
    public void add(int key) {
        // arr[key] = 1;
        bs.set(key);
    }
    
    public void remove(int key) {
        bs.clear(key);
    }
    
    public boolean contains(int key) {
        return bs.get(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */