class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        Map<Integer, Integer> hs = new HashMap();
        int cs = 0, diff;
        hs.put(0, 1);
        for (int i = 0; i<n; i++) {
            cs+=nums[i];
            diff = cs - k;
            if (hs.containsKey(diff)) ans+=hs.get(diff);
            hs.put(cs, hs.getOrDefault(cs, 0)+1);
        }
        return ans;
    }
}