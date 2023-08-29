class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int [] ans = new int[mat.length * mat[0].length];
        int co = 0;
        for (int i = 0; i < 2 * Math.max(mat.length, mat[0].length); i++) {
            int temp1 = Math.min(i, mat[0].length - 1);
            for (int j = 0; j <= temp1; j++) {
                if (mat.length > i-j) {
                    ans[co++] = mat[i-j][j];
                } 
            }
            i++;
            temp1 = Math.min(i, mat.length - 1);
            for (int j = 0; j <= temp1; j++) {
                if (mat[0].length > (i - j)) {
                    ans[co++] = mat[j][i-j];
                } 
            }
        }
        return ans;
    }
}