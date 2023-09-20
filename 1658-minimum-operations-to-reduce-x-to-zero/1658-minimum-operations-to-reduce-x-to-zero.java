class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> hm = new HashMap();
        Map<Integer, Integer> bhm = new HashMap();
        int ls = 0, rs = 0, ans = Integer.MAX_VALUE, temp;
        hm.put(0,-1);
        for (int i = 0; i< nums.length && ls <= x; i++) {
            ls += nums[i];
            if (ls == x) ans = Math.min(i+1, ans);
            hm.put(ls, i);
        }
        for (int i = nums.length - 1; i >= 0 && rs<=x; i--) {
            rs += nums[i];
            if(hm.containsKey(x-rs) && i > hm.get(x-rs)) ans = Math.min(ans, hm.get(x-rs) + nums.length - i + 1);
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}