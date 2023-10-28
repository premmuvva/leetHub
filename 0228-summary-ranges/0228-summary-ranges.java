class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList();
        int n = nums.length, st, i;
        for (i = 0; i < n - 1; i++) {
            if (nums[i+1] == nums[i] + 1) {
                st = nums[i];
                while(i+1<n && nums[i] + 1 == nums[i+1]) i++;
                if (i+1 == n) i = n-1;
                ans.add(String.valueOf(st) + "->" + String.valueOf(nums[i]));
            } else {
                ans.add(String.valueOf(nums[i]));
            }
        }
        if(i == n -1) ans.add(String.valueOf(nums[n-1]));
        return ans;
    }
}