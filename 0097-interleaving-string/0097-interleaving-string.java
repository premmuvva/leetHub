class Solution {
    private boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new boolean[s1.length() + 1][s2.length() + 1];
        return s1.length() + s2.length() == s3.length() && process(s1, s2, s3, 0, 0);
    }
    
    private boolean process(String s1, String s2, String s3, int a, int b) {
        if (s3.length() == a + b) return true;
        if (dp[a][b]) return false;
        if ( s1.length() > a && s3.charAt(a+b) == s1.charAt(a) && process(s1, s2, s3, a + 1, b)) {
            return true;
        }  else {
            dp[a][b] = true;
        }
        if (s2.length() > b && s3.charAt(a+b) == s2.charAt(b) && process(s1, s2, s3, a, b + 1)) {
            return true;
        }  else {
            dp[a][b] = true;
        }  
        return false;
    }
}