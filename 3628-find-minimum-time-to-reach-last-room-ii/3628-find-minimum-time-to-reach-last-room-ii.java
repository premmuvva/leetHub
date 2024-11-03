class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        // pq.add(new int[]{arr[m-1][n-1], m-1, n-1});
        pq.add(new int[]{0, 0, 0, 2});
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;
        int dp[][] = new int[m][n];
        int i , j, val, alt;
        while(!pq.isEmpty()) {
            int[] po = pq.poll();
            val = po[0];
            i = po[1];
            j = po[2];
            alt = po[3] == 1 ? 2 : 1;
            if (i == m-1 && j == n-1) return val;
            if (j > 0 && !vis[i][j-1]) {
                vis[i][j-1] = true;
                pq.add(new int[]{Math.max(val, moveTime[i][j-1]) + alt, i, j-1, alt});
            }
            if (j < n -1 && !vis[i][j+1]) {
                vis[i][j+1] = true;
                pq.add(new int[]{Math.max(val, moveTime[i][j+1]) + alt, i, j+1, alt});
            }
            if (i > 0 && !vis[i-1][j]) {
                vis[i-1][j] = true;
                pq.add(new int[]{Math.max(val, moveTime[i-1][j]) + alt, i-1, j, alt});
            }
            if (i < m-1 && !vis[i+1][j]) {
                vis[i+1][j] = true;
                pq.add(new int[]{Math.max(val, moveTime[i+1][j]) + alt, i+1, j, alt});
            }
        }
        return 0;
    }
}