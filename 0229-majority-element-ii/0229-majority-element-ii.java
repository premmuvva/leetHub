class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList();
        int n = nums.length/3;
        for(int i = n; i < nums.length; i++) {
            if (nums[i-n] == nums[i]) {
                if(!ans.contains(nums[i])) ans.add(nums[i]);
                i+=n;
            }
        }
        return ans;
    }
}