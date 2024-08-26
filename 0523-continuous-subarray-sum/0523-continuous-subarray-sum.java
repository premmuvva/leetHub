class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap();
        int mod = 0;
        hm.put(0, -1);
        for (int i = 0; i<n; i++) {
            // nums[i] += nums[i-1];
            mod = (mod + nums[i]) % k;
            if (hm.containsKey(mod)) {
                if (i - 1 != hm.get(mod)) return true;
            } else {
                hm.put(mod, i);
            }
        }
        return false;
    }
}