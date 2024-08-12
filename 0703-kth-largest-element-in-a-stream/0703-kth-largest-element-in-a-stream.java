class KthLargest {

    PriorityQueue<Integer> pq;
    int[] nums;
    int k;
    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        for (int i : nums) {
            pq.add(i);
        }
        while(pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */