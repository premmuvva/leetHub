class Solution {
    public boolean validPalindrome(String s) {
        return rec(s, true);
    }
    
    boolean rec(String s, boolean isFirst) {
        int n = s.length(), st = 0, en = n-1;
        // System.out.println(s);
        while(st<en) {
            if (s.charAt(st) == s.charAt(en)) {
                st++;
                en--;
            } else {
                if (isFirst)
                    return rec(s.substring(st, en), false) || rec(s.substring(st + 1, en + 1), false);
                return false;
            }
        }
        return true;
    }
}