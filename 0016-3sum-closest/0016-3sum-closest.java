class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = 100000, ans = 0;
        TreeSet<Integer> ts = new TreeSet();
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                int temp = target - nums[i] - nums[j];
                Integer val = ts.ceiling(temp);
                if (val != null) {
                    if (diff > val - temp) {
                        diff = val - temp;
                        ans = val + nums[i] + nums[j];
                    }
                }
                val = ts.floor(temp);
                if (val != null) {
                    if (diff > temp - val) {
                        diff = temp - val;
                        ans = val + nums[i] + nums[j];
                    }
                }
            }
            ts.add(nums[i]);
        }
        return ans;
    }
}