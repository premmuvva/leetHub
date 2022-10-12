class Solution {
    public String breakPalindrome(String palindrome) {
        int i = 0, n = palindrome.length();
        if (n == 1) return "";
        while(i < n) if (palindrome.charAt(i++) != 'a') break;
        if (i - 1 == n/2 && (n&1) == 1) 
            while(i < n) if (palindrome.charAt(i++) != 'a') 
                break;
        i--;
        final StringBuffer str = new StringBuffer(palindrome);
        if (i == n-1) str.setCharAt(i, 'b');
        else str.setCharAt(i, 'a');
        return str.toString();
    }
}