class Solution {
    public int countVowelPermutation(int n) {
        long dp[][] = new long[2][5];
        dp[0][0] = 1L; // a
        dp[0][1] = 1L; // e
        dp[0][2] = 1L; // i
        dp[0][3] = 1L; // o
        dp[0][4] = 1L; // u
        int temp, nt;
        for(int i = 1; i<n; i++) {
            temp = i%2;
            nt = (i+1)%2;
            dp[temp][0] = (dp[nt][1] + dp[nt][2] + dp[nt][4]) % 1000000007L; //a
            dp[temp][1] = (dp[nt][0] + dp[nt][2]) % 1000000007L; //e
            dp[temp][2] = (dp[nt][1] + dp[nt][3]) % 1000000007L; //i
            dp[temp][3] = dp[nt][2]; //o
            dp[temp][4] = (dp[nt][2] + dp[nt][3]) % 1000000007L; //u
            // System.out.println(Arrays.toString(dp[temp]));
        }
        temp = --n%2;
        return (int) ((dp[temp][0] + dp[temp][1] + dp[temp][2] + dp[temp][3] + dp[temp][4]) % 1000000007L);
    }
}