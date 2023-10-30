class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int[] ans = new int[k];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
            if(pq.size() > k) pq.poll();
        }
        // System.out.println(Arrays.deepToString(pq.toArray()));
        while(pq.size() != 0) 
            pq1.add(pq.poll());
        int i = 0;
        // System.out.println(Arrays.deepToString(pq1.toArray()));
        // System.out.println();
        while(pq1.size() != 0) {
            ans[i++] = pq1.poll()[0];
        }
        return ans;
    }
}