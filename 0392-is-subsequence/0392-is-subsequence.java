class Solution {
    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) return false;
        int i = 0;
        if(i == s.length()) return true;        
        for(char c: t.toCharArray()) {
            if(s.charAt(i) == c) {
                i++;
                if(i == s.length()) return true;        
            }
        }
        return i == s.length();
    }
}