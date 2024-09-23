class Solution {
    int mod = 10000007, base = 29, base2 = 31;
    public int minExtraChar(String s, String[] dick) {
        Set<Integer> hs = new HashSet();
        Set<Integer> hs2 = new HashSet();
        int hash, hash2, mul, mul2;
        // for (int i = 0; i<s.length(); i++) {
        //     System.out.print(s.charAt(i) + " - " + i + ", ");
        // }
        // System.out.println();
        for (String str: dick) {
            hash = 0;
            mul2 = base2;
            hash2 = 0;
            mul = base;
            for (char ch: str.toCharArray()) {
                hash = (hash + mul * (ch -'a' + 1)) % mod;
                mul = (mul * base) % mod;
                hash2 = (hash2 + mul2 * (ch -'a' + 1)) % mod;
                mul2 = (mul2 * base2) % mod;
            }
            hs.add(hash);
            hs2.add(hash2);
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        // System.out.println(hs);
        return rec(s.toCharArray(), hs, hs2, 0, s.length(), dp);
    }
    
    int rec(char[] s, Set<Integer> hs, Set<Integer> hs2, int st, int en, int dp[]) {
        int hash, mul, hash2, mul2;
        int ans = Integer.MAX_VALUE;
        if (st < en && dp[st] != -1) return dp[st];
        for (int i = st; i<en; i++) {
            hash = 0;
            mul2 = base2;
            hash2 = 0;
            mul = base;
            for (int j = i; j < en; j++) {
                hash = (hash + mul * (s[j] -'a' + 1)) % mod;
                mul = (mul * base) % mod;
                hash2 = (hash2 + mul2 * (s[j] -'a' + 1)) % mod;
                mul2 = (mul2 * base2) % mod;
                
                if (hs.contains(hash) && hs2.contains(hash2)) {
                    // hs.put(hash, hs.get(hash) - 1);
                    if (j + 1 == en) ans = Math.min(ans, i-st);
                    else
                        ans = Math.min(ans, i-st + rec(s, hs, hs2, j+1, en, dp));
                    // System.out.printf("%d %d %d %d %d\n", st, en, i, j, ans);
                    // if (st == 5 && en == 7) System.out.println(hash);
                    // hs.put(hash, hs.get(hash) + 1);
                } else {
                    // if (j + 1 == en) ans = Math.min(ans, i-st);
                    // else ans = Math.min(ans, j-st + rec(s, hs, j+1, en));
                }
            }
        }
        dp[st] = ans == Integer.MAX_VALUE ? en-st: ans;
        // System.out.printf("final : %d %d %d\n", st, en, dp[st]);
        return dp[st];
    }
}