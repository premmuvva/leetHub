class Solution {
    public int maxFrequency(int[] nums, int k) {
        // TreeMap<Integer, Integer> hm = new TreeMap();
        int n = nums.length;
        if (n ==1) return 1;
        Arrays.sort(nums);
        // int [] val = new int[n];
        // val[0] = nums[]
        // for (int i = 1; i< n; i++) {
        //     val[i] = (nums[i] - nums[i - 1]);
        // }
        // System.out.println(Arrays.toString(nums));
        int st = 0, en = 1, ans = 0;
        long te = 0L;
        while(en < n) {
            if (te > k) {
                te -= (nums[en-1] - nums[st]);
                st++;
                // System.out.printf("sub %d %d %d %d\n", st, en, te, nums[en-1] - nums[st]);
                continue;
            }
            ans = Math.max(ans, en-st);
            te = (nums[en] - nums[en-1]) * ((long)en-st) + te;
            en++;
            
            // System.out.printf("%d %d %d %d\n", st, en, te, ans);
        }
        if (te <= k) ans = Math.max(ans, en-st);
        // System.out.printf("%d %d %d\n", st, en, te);
        return ans;
    }
}