class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack();
        int ans = 0, n = nums.length, temp[];
        st.push(0);
        for (int i = 1; i<n; i++) {
            if (nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }
        for(int i = n-1; !st.isEmpty() && i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                int val = st.pop();
                ans = Math.max(ans, i - val);
            }
        }
        return ans;
    }
}