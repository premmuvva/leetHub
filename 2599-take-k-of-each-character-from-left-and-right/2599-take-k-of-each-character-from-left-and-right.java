class Solution {
    public int takeCharacters(String s, int k) {
        int a = 0, b = 0, c = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;
        }
        if (a < k || b < k || c < k) return -1;

        int n = s.length(), st = 0, ca = 0, cb = 0, cc = 0, ans = 0;

        for (int en = 0; en<n; en++) {
            char ch = s.charAt(en);
            if (ch == 'a') ca++;
            else if (ch == 'b') cb++;
            else if (ch == 'c') cc++;
            while(st <= en && (a - ca < k || b - cb < k || c - cc < k)) {
                ch = s.charAt(st);
                if (ch == 'a') ca--;
                else if (ch == 'b') cb--;
                else if (ch == 'c') cc--;
                st++;
            }
            ans = Math.max(ans, en - st + 1);
        }
        return n-ans;
    }
}