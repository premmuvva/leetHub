class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> qu = new ArrayDeque();
        // for(int i = 0 ;i < k; i++) {
        //     qu.offer(i);
        // }
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while(qu.size() > 0 && i - qu.peek() >= k) qu.pollFirst();
            while(qu.size() > 0 && nums[i] >= nums[qu.peekLast()]) qu.pollLast();
            qu.offer(i);
            int temp = Integer.MIN_VALUE;
            if(i >= k - 1) 
                ans[i - k + 1] = nums[qu.peekFirst()];
        }
        return ans;
    }
}