class Solution {
    class Node {
        Node [] ch;
        public Node() {
            ch = new Node[26];
        }
    }
    public int minValidStrings(String[] words, String target) {
        Node st = new Node(), temp;
        for (String str: words) {
            temp = st;
            for (char ch: str.toCharArray()) {
                if (temp.ch[ch-'a'] == null) {
                    temp.ch[ch-'a'] = new Node();
                }
                temp = temp.ch[ch-'a'];
            }
        }
        temp = st;
        int ans = 1, n = target.length();
        int[] dp = new int[n+2];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i<n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            temp = st;
            for (int j = i; j < n; j++) {
                char ch = target.charAt(j);
                if (temp.ch[ch-'a'] == null) break;
                temp = temp.ch[ch-'a'];
                dp[j+1] = Math.min(dp[j+1], dp[i] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}