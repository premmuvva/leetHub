class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        for (int i = 1; i<n; i++) {
            arr[i] ^= arr[i-1];
        }
        int i=0, ans[] = new int[queries.length];
        for (int[] ar: queries) {
            if (ar[0] != 0) {
                ans[i] = arr[ar[0]-1];
            }
            ans[i++] ^= arr[ar[1]];
        }
        return ans;
    }
}