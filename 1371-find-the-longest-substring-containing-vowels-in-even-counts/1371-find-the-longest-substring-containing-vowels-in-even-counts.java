class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> hm = new HashMap(){{
            put('a', 1);
            put('e', 2);
            put('i', 4);
            put('o', 8);
            put('u', 16);
        }};
        int xor = 0, dp[] = new int[35], ans = 0, n = s.length();
        Arrays.fill(dp, -1);
        for (int i = 0; i<n; i++) {
            char ch = s.charAt(i);
            // if (!hm.containsKey(ch)) continue;
            xor ^= hm.getOrDefault(ch, 0);
            if (dp[xor] == -1 && xor != 0) {
                dp[xor] = i;
            }
            ans = Math.max(ans, i-dp[xor]);
        }
        return ans;
    }
}