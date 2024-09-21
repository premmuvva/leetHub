class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = 1, n = s.length();
        String str = s + '*' + (new StringBuffer(s)).reverse().toString();
        n *= 2;
        n++;
        int dp[] = new int[n];
        while(j< n) {
            if (str.charAt(i) == str.charAt(j)) {
                dp[j] = i + 1;
                i++;
            } else {
                while(i != 0 && str.charAt(i) != str.charAt(j)) {
                    i = i > 0 ? dp[i-1] : 0;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    dp[j] = i + 1;
                    i++;
                }
                else dp[j] = dp[i];
            }
            j++;
        }
        // System.out.println(str);
        // System.out.println(Arrays.toString(dp));
        return (new StringBuffer(s.substring(dp[n-1]))).reverse().toString() + s;
    }
}