class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length, i = 0, j, k = n-1, cs;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList();
        if (nums[n-1] < 0) return ans;
        for(; i<n; i++) {
            if (nums[i] > 0) break;
            j = i + 1;
            k = n-1;
            while(j < k) {
                if (nums[i] + nums[j] > 0) break;
                int sum = nums[j] + nums[i] + nums[k];
                if (sum == 0) {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k-1] == nums[k]) k--;
                    j++;k--;
                } else if (sum > 0) k--;
                else j++;
            }
            while(i < n-1 && nums[i] == nums[i+1]) i++;
        }
        return ans;
        // while (i < n) {
        //     cs = (nums[i] + nums[k]) * -1;
        //     if (nums[i] >= cs || nums[k] <= cs) {
        //         i++;
        //     }
        // }
    }
    
    // int bs(int val, int[] nums, int i, int j) {
    //     if (i == j) return nums[i] == val ? i : 1;
    //     int mid = i + (j - i) / 2;
    //     if (mid == val) return mid;
    //     if (mid < val) return bs(val, nums, mid + 1, j);
    //     if (mid < val) return bs(val, nums, mid + 1, j);
    // }
}