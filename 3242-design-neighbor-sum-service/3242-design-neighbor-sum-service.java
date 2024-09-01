class NeighborSum {
    
    
    int [][]grid;
    int n;
    Map<Integer, Pair<Integer,Integer>> hm;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        hm = new HashMap();
        int k = 0;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                hm.put(grid[i][j], new Pair(i, j));
            }
        }
    }
    
    public int adjacentSum(int inp) {
        Pair<Integer,Integer> value = hm.get(inp);
        int ans = 0;
        if (value.getKey() != 0) {
            ans += grid[value.getKey() - 1][value.getValue()];
        }
        if (value.getKey() != n-1) {
            ans += grid[value.getKey() + 1][value.getValue()];
        }
        if (value.getValue() != 0) {
            ans += grid[value.getKey()][value.getValue() - 1];
        }
        if (value.getValue() != n-1) {
            ans += grid[value.getKey()][value.getValue() + 1];
        }
        return ans;
    }
    
    public int diagonalSum(int inp) {
        Pair<Integer,Integer> value = hm.get(inp);
        int ans = 0;
        if (value.getKey() != 0 && value.getValue() != 0) {
            ans += grid[value.getKey() - 1][value.getValue() - 1];
        }
        if (value.getKey() != n-1 && value.getValue() != n - 1) {
            ans += grid[value.getKey() + 1][value.getValue() + 1];
        }
        if (value.getKey() != n-1 && value.getValue() != 0) {
            ans += grid[value.getKey() + 1][value.getValue() - 1];
        }
        if (value.getKey() != 0 && value.getValue() != n-1) {
            ans += grid[value.getKey() - 1][value.getValue() + 1];
        }
        return ans;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */