class Solution {
    public char findTheDifference(String s, String t) {
        int []dp = new int[26];
        for (char c: s.toCharArray()) dp[c-'a']++;
        for (char c : t.toCharArray()) {
            if(--dp[c-'a'] < 0) return c;
        }
        return 'a';
    }
}