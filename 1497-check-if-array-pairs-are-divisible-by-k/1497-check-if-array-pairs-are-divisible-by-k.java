class Solution {
    public boolean canArrange(int[] arr, int k) {
        int dp [] = new int [k];
        for(int n: arr) {
            dp[(n%k + k)%k]++;
        }
        int i = 1;
        k--;
        while(i<k) {
            if (dp[i] != dp[k]) return false;
            i++;k--;
        }
        if (i == k) return dp[i]%2 == 0;
        return true;
    }
}