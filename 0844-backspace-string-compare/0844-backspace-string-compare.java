class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1 = s.length() -1, n2 = t.length() - 1;
        // System.out.println();
        int bs;
        while(n1 >= 0 && s.charAt(n1) == '#') {
            bs = 1;
            n1--;
            while(n1 >= 0 && bs != 0) {
                if(s.charAt(n1--) == '#')
                    bs++;
                else bs--;
            }
        }
        while(n2 >= 0 && t.charAt(n2) == '#') {
            bs = 1;
            n2--;
            while(n2 >= 0 && bs != 0) {
                if(t.charAt(n2--) == '#')
                    bs++;
                else bs--;
            }
        }
        while(n1 >= 0 && n2 >= 0) {
            // System.out.println(n1);
            if(n1 < 0 || n2 < 0 || s.charAt(n1) != t.charAt(n2)) return false;
            n1--;
            n2--;
            while(n1 >= 0 && s.charAt(n1) == '#') {
                bs = 1;
                n1--;
                while(n1 >= 0 && bs != 0) {
                    if(s.charAt(n1--) == '#')
                        bs++;
                    else bs--;
                }
                // n1 -= bs;
                // n1 -= bs;
            }
            // System.out.println(n1);
            while(n2 >= 0 && t.charAt(n2) == '#') {
                bs = 1;
                n2--;
                while(n2 >= 0 && bs != 0) {
                    if(t.charAt(n2--) == '#')
                        bs++;
                    else bs--;
                }
            }
            // System.out.println(n2);
            if(n1 < 0 && n2 < 0) return true;
            
        }
        
        if(n1 != n2) return false;
        return true;
    }
}