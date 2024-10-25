class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int ans = 0, n = chars.length, co = 0;
        for (int j = 0; j < n; j++) {
            if (chars[i] == chars[j]) {
                co++;
            } else {
                if (co > 1)
                for(char ch: String.valueOf(co).toCharArray()) {
                    ans++;
                    chars[ans] = ch;
                }
                ans++;
                chars[ans] = chars[j];
                i = j;
                co = 1;
            }
        }
        if (co > 1)
        for(char ch: String.valueOf(co).toCharArray()) {
            ans++;
            chars[ans] = ch;
        }
        return ans + 1;
    }
}