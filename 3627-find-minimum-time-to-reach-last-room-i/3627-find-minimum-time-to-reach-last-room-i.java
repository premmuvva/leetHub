class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // pq.add(new int[]{arr[m-1][n-1], m-1, n-1});
        pq.add(new int[]{0, 0, 0});
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;
        int dp[][] = new int[m][n];
        int i , j, val;
        while(!pq.isEmpty()) {
            int[] po = pq.poll();
            val = po[0];
            i = po[1];
            j = po[2];
            if (i == m-1 && j == n-1) return val;
            if (j > 0 && !vis[i][j-1]) {
                vis[i][j-1] = true;
                pq.add(new int[]{Math.max(val, moveTime[i][j-1]) + 1, i, j-1});
            }
            if (j < n -1 && !vis[i][j+1]) {
                vis[i][j+1] = true;
                pq.add(new int[]{Math.max(val, moveTime[i][j+1]) + 1, i, j+1});
            }
            if (i > 0 && !vis[i-1][j]) {
                vis[i-1][j] = true;
                pq.add(new int[]{Math.max(val, moveTime[i-1][j]) + 1, i-1, j});
            }
            if (i < m-1 && !vis[i+1][j]) {
                vis[i+1][j] = true;
                pq.add(new int[]{Math.max(val, moveTime[i+1][j]) + 1, i+1, j});
            }
        }
        return 0;
        // return rec(moveTime, vis, dp, 0, 0, m, n, -1);
    }

    int rec(int[][] arr, boolean[][] vis, int[][] dp, int i, int j, int m, int n, int cur) {
        if (i < 0 || j < 0 || i >= m || j >= n || vis[i][j]) return -1;
        if(i == m-1 && j == n-1) return cur+1;
        if (dp[i][j] != 0) return dp[i][j];
        vis[i][j] = true;
        // cur = Math.max(cur, arr[i][j]) + 1;
        
        int ans = Integer.MAX_VALUE;
        if (j > 0) {
            int l = rec(arr, vis, dp, i, j-1, m, n, Math.max(cur + 1, arr[i][j-1]));
            if (l != -1) {
                ans = Math.min(ans, l);
            }
        }
        if (j < n-1) {
            int l = rec(arr, vis, dp, i, j+1, m, n, Math.max(cur + 1, arr[i][j+1]));
            if (l != -1) {
                ans = Math.min(ans, l);
            }
        }
        if (i > 0) {
            int l = rec(arr, vis, dp, i-1, j, m, n, Math.max(cur + 1, arr[i-1][j]));
            if (l != -1) {
                ans = Math.min(ans, l);
            }
        }
        if (i < m-1) {
            int l = rec(arr, vis, dp, i+1, j, m, n, Math.max(cur + 1, arr[i+1][j]));
            if (l != -1) {
                ans = Math.min(ans, l);
            }
        }
        // int r = rec(arr, vis, i, j+1, m, n, cur);
        // int u = rec(arr, vis, i-1, j, m, n, cur);
        // int d = rec(arr, vis, i+1, j, m, n, cur);
        vis[i][j] = false;
        
        // if (r != -1) {
        //     ans = Math.min(ans, r);
        // }
        // if (u != -1) {
        //     ans = Math.min(ans, u);
        // }
        // if (d != -1) {
        //     ans = Math.min(ans, d);
        // }
        dp[i][j] = ans;
        return ans;
    }
}