class Solution {
    public int longestSquareStreak(int[] nums) {
        TreeSet<Long> ts = new TreeSet();
        for (int i: nums) ts.add((long)i);
        int ans = 0;
        for (long i: ts) {
            int cur = 1;
            long pro = i;
            while(pro < 100001 && ts.contains(pro * pro)) {
                pro *= pro;
                cur ++;
            }
            ans = Math.max(ans, cur);
        }
        return ans == 1 ? -1 : ans;
    }
}