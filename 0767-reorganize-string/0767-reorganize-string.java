class Solution {
    public String reorganizeString(String s) {
        int[] dp = new int[26];
        int max = 0, maxc = 0;
        for(char c: s.toCharArray()) {
            if (++dp[c - 'a'] > max) {
                max = dp[c - 'a'];
                maxc = c;
            }
        }
        if (max > (s.length() + 1) / 2) return "";
        char[] ans = new char[s.length()];
        int cou = 0;
        while (max-- >0) {
                if (cou >= s.length()) cou = 1;
                ans[cou] = (char) (maxc);
                cou += 2;
            }
        for (int i = 25; i >= 0; i--) {
            if (i == (maxc-'a')) continue;
            while (dp[i]-- >0) {
                if (cou >= s.length()) cou = 1;
                ans[cou] = (char) ('a' + i);
                cou += 2;
            }
            
        }
        return String.valueOf(ans);
    }
}