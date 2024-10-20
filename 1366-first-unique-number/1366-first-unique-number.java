class FirstUnique {

    List<Integer> arr;
    Set<Integer> set, uni;
    int cur;
    public FirstUnique(int[] nums) {
        // pq = new PriorityQueue<int[]>((a, b)-> a[1]-b[1]);
        arr = new ArrayList();
        set = new HashSet();
        uni = new HashSet();
        cur = 0;
        for (int i: nums) {
            add(i);
        }
    }
    
    public int showFirstUnique() {
        for (int i: arr) {
            if (uni.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public void add(int value) {
        if (!set.contains(value)) {
            set.add(value);
            uni.add(value);
            // pq.offer(new int[]{value})
            arr.add(value);
        } else {
            uni.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */