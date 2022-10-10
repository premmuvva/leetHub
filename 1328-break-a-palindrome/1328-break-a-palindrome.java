class Solution {
    public String breakPalindrome(String palindrome) {
        int i = 0, n = palindrome.length();
        if (n == 1) return "";
        while(i < n) if (palindrome.charAt(i++) != 'a') break;
        // i--;
        if (i - 1 == n/2 && (n&1) == 1) {
            // i++;
            // System.out.println(i);
            while(i < n) if (palindrome.charAt(i++) != 'a') break;
            
        }
        // System.out.println(i);
        i--;
        StringBuffer str = new StringBuffer(palindrome);
        if (i == n-1) str.setCharAt(i, 'b');
        else str.setCharAt(i, 'a');
        return str.toString();
    }
}