class Solution {
    public String makeFancyString(String s) {
        int c = 0, cc = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                c++;
            } else {
                ans.append(s.substring(cc, c != 0? i - c + 1 : i));//ans += (c - 1);
                c = 0;
                cc = i;
            }
        }
        ans.append(s.substring(cc, c != 0? s.length() - c + 1: s.length()));
        return ans.toString();
    }
}