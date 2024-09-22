class Solution {
    public long validSubstringCount(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length(), i;
        int a2[] = new int[27], a1[] = new int[27];
        for (char ch: word2.toCharArray()) {
            a2[ch-'a']++;
        }
        Set<Integer> mc= new HashSet();
        for (i = 0; i<27; i++) if (a2[i] != 0) mc.add(i);
        for (i = 0; i<n1; i++) {
            if (mc.isEmpty()) break;
            int ch= word1.charAt(i)-'a';
            a1[ch]++;
            if (a1[ch] >= a2[ch]) mc.remove(ch);
        }
        // System.out.println(i);
        if (!mc.isEmpty()) return 0;
        int en = i;
        long ans = n1 - en + 1;

            // System.out.println(ans);
        int st = 0;
        while (en < n1) {
            int ch = word1.charAt(st)-'a';
            if (a1[ch] - 1 >= a2[ch]) {
                ans += n1 - en + 1;
                a1[ch]--;
                st++;
            } else {
                ch = word1.charAt(en)-'a';
                a1[ch]++;
                en++;
            }
            // System.out.printf("%d %s\n", ans, word1.substring(st, en));
        }
        int ch = word1.charAt(st)-'a';
        // System.out.println();
        while (a1[ch] - 1 >= a2[ch]) {
                ans += n1 - en + 1;
                a1[ch]--;
                st++;
                ch = word1.charAt(st)-'a';
            // System.out.printf("%d %s\n", ans, word1.substring(st, en));
            }
        // System.out.println(ans);
        return ans;
    }
}