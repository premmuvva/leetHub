class Solution {
    public int countSquares(int[][] matrix) {
        int dp[] = new int[301];
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if(matrix[i][j] == 1) {
                    int cou = 0;
                    while(count(matrix, i, j, cou)) {
                        cou++;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    boolean count(int[][] arr, int i, int j, int offset) {
        if (i+offset >= arr.length || j + offset >= arr[0].length) return false;
        for (int ii = 0; ii<=offset; ii++) {
            if (arr[ii+i][j+offset] != 1 || arr[i+offset][ii+j] != 1) return false;
        }
        return true;
    }

    // double nCR(int n, int r){
    //     if (n < r) {
    //         return -1;
    //     }
    //     else if (n == r || r == 0) {
    //         return 1;
    //     }
    //     else {
    //         int max_val = std::max(r, n - r);
    //         int min_val = std::min(r, n - r);
    //         double numerator = Multiplier(max_val + 1, n);
    //         double denominator = Multiplier(1, min_val);
    //         return numerator / denominator;
    //     }
    // }
}