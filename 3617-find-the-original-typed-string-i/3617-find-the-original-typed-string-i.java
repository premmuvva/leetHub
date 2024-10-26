class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 1, cur = 0;
        for (int i = 0; i<n-1; i++) {
            if (word.charAt(i) == word.charAt(i+1)) {
                cur++;
            } else {
                ans += (cur);
                cur = 0;
            }
        }
        ans += (cur);
        return ans == 0 ? 1 : ans;
    }
}