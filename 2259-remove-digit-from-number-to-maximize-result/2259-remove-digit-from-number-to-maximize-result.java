class Solution {
    public String removeDigit(String number, char digit) {
        int ans = -1, n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                ans = i;
                if (i + 1 < n && number.charAt(i) < number.charAt(i+1)) break;
            }
        }
        return number.substring(0,ans) + number.substring(ans+1, n);
    }
}