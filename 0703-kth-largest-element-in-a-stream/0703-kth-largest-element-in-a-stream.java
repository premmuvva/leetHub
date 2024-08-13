class KthLargest {

    PriorityQueue<Integer> pq;
    int[] nums;
    int k;
    public KthLargest(int k, int[] nums) {
        this.nums = nums;
        this.pq = new PriorityQueue<Integer>();
        this.k = k;
        int n = nums.length;
        for (int i = 0; i < Math.min(k, n); i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < n; i++) {
            if (nums[i] > pq.peek()){
                pq.add(nums[i]);
                pq.poll();
            }
        }
        // while(pq.size() > k) {
        //     pq.poll();
        // }
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