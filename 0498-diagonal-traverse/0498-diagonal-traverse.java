class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int [] ans = new int[mat.length * mat[0].length];
        int co = 0;
        for (int i = 0; i < 2 * Math.max(mat.length, mat[0].length); i++) {
            
            for (int j = 0; j <= i; j++) {
                if (mat.length > i-j && mat[0].length > (j)) {
                    ans[co++] = mat[i-j][j];
                } 
            }
            i++;
            for (int j = 0; j <= i; j++) {
                if (mat.length > j && mat[0].length > (i - j)) {
                    ans[co++] = mat[j][i-j];
                } 
            }
        }
        return ans;
    }
}