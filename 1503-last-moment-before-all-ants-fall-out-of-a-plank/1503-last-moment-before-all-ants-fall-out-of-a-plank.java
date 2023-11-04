class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for(int i : left) {
            ans = Math.max(ans, i);
        }
         for(int i : right) {
            ans = Math.max(ans, n-i);
        }
        return ans;
    }
}