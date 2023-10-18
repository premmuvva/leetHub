class Solution {
    int[] sol;
    public int minimumTime(int n, int[][] relations, int[] time) {
        sol = new int[n+1];
        int ans = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> dp = new HashMap();
        for (int[] i: relations) {
            dp.computeIfAbsent(i[1], v -> new ArrayList()).add(i[0]);
        }
        for(int i = 1; i <= n; i++) {
            ans = Math.max(cal(i, dp, time), ans);
        }
        return ans;
    }
    
    private int cal(int n, Map<Integer, List<Integer>> dp, int[] time) {
        if (sol[n] != 0) return sol[n];
        int ans = Integer.MIN_VALUE, nt = time[n-1];
        for(int i : dp.getOrDefault(n, new ArrayList<Integer>())) {
            ans = Math.max(cal(i, dp, time) + nt, ans);
        }
        sol[n] = Math.max(nt, ans);
        return sol[n];
    }
    
}