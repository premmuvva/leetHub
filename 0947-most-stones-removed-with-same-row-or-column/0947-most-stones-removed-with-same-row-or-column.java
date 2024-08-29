class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int dp[] = new int[n];
        Map<Integer, List<Integer>> xn = new HashMap();
        Map<Integer, List<Integer>> yn = new HashMap();
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            xn.computeIfAbsent(stones[i][0], k -> new ArrayList()).add(i);
            yn.computeIfAbsent(stones[i][1], k -> new ArrayList()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> en: xn.entrySet()) {
            List<Integer> li = en.getValue();
            for (int i = 0; i<li.size(); i++) {
                // dp[li.get(i)] = dp[li.get(0)];
                if(dp[li.get(i)] != dp[li.get(0)]) {
                    int temp = dp[li.get(i)];
                    for (int ii = 0; ii < n; ii++) {
                        if (dp[ii] == temp) {
                            dp[ii] = dp[li.get(0)];
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        for (int i = 0; i<n; i++)
            rec(dp, i);
        // System.out.println(Arrays.toString(dp));
        // System.out.println(yn);
        for (Map.Entry<Integer, List<Integer>> en: yn.entrySet()) {
            List<Integer> li = en.getValue();
            for (int i = 0; i<li.size(); i++) {
                if(dp[li.get(i)] != dp[li.get(0)]) {
                    int temp = dp[li.get(i)];
                    for (int ii = 0; ii < n; ii++) {
                        if (dp[ii] == temp) {
                            dp[ii] = dp[li.get(0)];
                        }
                    }
                }
                // System.out.printf("%d %d\n", li.get(0), li.get(i));
                // System.out.println(Arrays.toString(dp));
                // rec(dp, li.get(i));
            }
        }
        // System.out.println(Arrays.toString(dp));
        Set<Integer> hs = new HashSet();
        for (int i = 0; i<n; i++)
            hs.add(dp[i]);        
        return n - hs.size();
    }
    
    int rec(int[] dp, int i) {
        if(dp[i] != i) {
            dp[i] = rec(dp, dp[i]);
        }
        return dp[i];
    }
}