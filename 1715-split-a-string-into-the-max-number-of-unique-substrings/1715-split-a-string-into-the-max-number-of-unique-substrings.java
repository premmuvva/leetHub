class Solution {
    public int maxUniqueSplit(String s) {
        Set<Long> hs = new HashSet();
        int n = s.length();
        // long mod = 1000000007, hash = 0, mul = 29, pro = 1;
        // for (int i = 0; i<n; i++) {
        //     hash = (s.charAt(i++) - 'a' + 1);
        //     pro = 1;
        //     while(hs.contains(hash) && i < n) {
        //         hash = (hash * pro + (s.charAt(i++) - 'a' + 1)) % mod;
        //         // System.out.printf("%d %d")
        //         pro = (pro * mul) % mod;
        //     }
        //     if (i == n && hs.contains(hash)) {
        //         hs.remove(hs.iterator().next());
        //     } else
        //         hs.add(hash);
        // }
        // System.out.println(hs);

        return backtrack(s, new HashSet<String>());
        // return hs.size();
    }

    int backtrack(String s, Set<String> hs) {
        if (s.length() == 0) return 0;
        int ans = 0;
        for (int en = 0; en<s.length(); en++) {
            String sub = s.substring(0, en+1);
            if (!hs.contains(sub)) {
                hs.add(sub);
                ans = Math.max(ans, 1+backtrack(s.substring(en+1), hs));
                hs.remove(sub);
            }
        }
        return ans;
    }
}