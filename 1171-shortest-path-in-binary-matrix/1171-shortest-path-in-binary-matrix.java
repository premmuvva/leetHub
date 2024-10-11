class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans = Integer.MAX_VALUE, n = grid.length;
        Queue<int[]> pq = new LinkedList();
        if (grid[0][0] == 1) return -1;
        if (n == 1) return 1;
        pq.offer(new int[]{0,0,1});
        int[][] dirs = {{0,1}, {1, 0}, {0,-1}, {-1,0}, {-1,-1}, {-1, 1}, {1, -1}, {1,1}};
        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            for (int[] dir: dirs) {
                int i = dir[0] + poll[0], j = dir[1] + poll[1];
                if (i < 0 || j < 0|| i >= n || j >= n || grid[i][j] == 1 || grid[i][j] == -1) continue;
                if (i == n-1 && j == n-1) {
                    ans = Math.min(ans, poll[2]+1);
                    continue;
                }
                grid[i][j] = -1;
                pq.offer(new int[]{i, j, poll[2]+1});
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int rec(int[][] grid, int i, int j, int n, int val) {
        if (i < 0 || j < 0|| i >= n || j >= n || grid[i][j] == 1|| grid[i][j] == -1) return 10000;
        if (i == n-1 && j == n-1) return val+1;
        if (grid[i][j] > 1) return grid[i][j];
        
        grid[i][j] = -1;
        int ans = Math.min(rec(grid, i+1, j, n, val + 1), rec(grid, i-1, j, n, val + 1));
        ans = Math.min(ans, rec(grid, i, j+1, n, val + 1));
        ans = Math.min(ans, rec(grid, i, j-1, n, val + 1));
        ans = Math.min(ans, rec(grid, i+1, j-1, n, val + 1));
        ans = Math.min(ans, rec(grid, i+1, j+1, n, val + 1));
        ans = Math.min(ans, rec(grid, i-1, j-1, n, val + 1));
        ans = Math.min(ans, rec(grid, i-1, j+1, n, val + 1));
        grid[i][j] = ans;
        return ans;
    }
}