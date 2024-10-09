class Solution {
    public int minAddToMakeValid(String s) {
        int co = 0, ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') ans++;
            else {
                ans--;
                if (ans < 0) {
                    co++;
                    ans++;
                }
            }
        }
        return ans + co;
    }
}