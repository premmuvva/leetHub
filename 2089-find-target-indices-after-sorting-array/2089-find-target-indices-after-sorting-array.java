class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        final List<Integer> ans = new ArrayList();
        int lower = 0, upper = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) lower++;
            else if (nums[i] > target) upper--;
        }
        for (int i = lower; i < upper; i++) {
            ans.add(i);
        }
        return ans;
    }
}