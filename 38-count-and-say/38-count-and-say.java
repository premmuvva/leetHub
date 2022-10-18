class Solution {
    public String countAndSay(int n) {
        if ( n == 1) return "1";
        // if ( n == 2) return "11";
        String s = countAndSay(n-1), ans = "";
        
        int count = 1;
        for (int i = 0; i< s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) count ++;
            else {
                ans = ans + String.valueOf(count) + String.valueOf(s.charAt(i));
                count = 1;
            }
        }
        ans = ans + String.valueOf(count) + String.valueOf(s.charAt(s.length()-1));
        
        // System.out.println(n + " " + ans);
        return ans;
    }
}