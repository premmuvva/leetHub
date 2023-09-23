class Solution {
    private int[] x = new int[]{0, 1, -1 ,0};
    private int[] y = new int[]{1, 0, 0, -1};
    
    private int dp[][] = new int[105][105];
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        
        pq.add(new int[]{0, 0, 0});
        
        while(!pq.isEmpty()) {
            int cur[] = pq.poll();
            int i = cur[1], j = cur[2];
            if(i == m -1 && j == n - 1) return cur[0];
            for (int te = 0; te < 4; te++) {
                int ni = i + x[te], nj = j + y[te];
                if(ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                int temp = Math.max( dp[i][j], Math.abs(heights[i][j] - heights[ni][nj]));
                if (temp < dp[ni][nj]) {
                    dp[ni][nj] = temp;
                    pq.add(new int[]{temp, ni, nj});
                }
            }
        }
        return dp[m-1][n-1];
    }
}