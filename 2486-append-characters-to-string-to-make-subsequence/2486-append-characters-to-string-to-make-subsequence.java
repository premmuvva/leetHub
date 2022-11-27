class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        char ch;
        boolean flag = false;
        for (; j < t.length() && s.length() > i; j++) {
            ch = t.charAt(j);
            flag = false;
            while(i < s.length()) {
                if (ch == s.charAt(i++)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) j--;
        }
        return t.length() == j && s.charAt(i-1) == t.charAt(j-1) ? 0 : t.length() - j;
    }
}