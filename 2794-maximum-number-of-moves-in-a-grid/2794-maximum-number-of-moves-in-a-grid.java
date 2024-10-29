class Solution {

    // The three possible directions for the next column.
    private final int[] dirs = { -1, 0, 1 };

    private int DFS(int row, int col, int[][] grid, int[][] dp) {
        int M = grid.length, N = grid[0].length;

        // If we have calculated the moves required for this cell, return the answer and skip the recursion.
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int maxMoves = 0;
        for (int dir : dirs) {
            // Next cell after the move.
            int newRow = row + dir, newCol = col + 1;

            // If the next cell is valid and greater than the current cell value,
            // perform recursion to that cell with updated value of moves.
            if (
                newRow >= 0 &&
                newCol >= 0 &&
                newRow < M &&
                newCol < N &&
                grid[row][col] < grid[newRow][newCol]
            ) {
                maxMoves = Math.max(
                    maxMoves,
                    1 + DFS(newRow, newCol, grid, dp)
                );
            }
        }

        dp[row][col] = maxMoves;
        return maxMoves;
    }

    public int maxMoves(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxMoves = 0;
        // Start DFS from each cell in the first column.
        for (int i = 0; i < M; i++) {
            int movesRequired = DFS(i, 0, grid, dp);
            maxMoves = Math.max(maxMoves, movesRequired);
        }

        return maxMoves;
    }
}