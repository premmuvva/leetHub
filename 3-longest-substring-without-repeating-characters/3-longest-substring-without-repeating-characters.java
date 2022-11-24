class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st = 1, cu = 1, ans = 0;
        int []pos = new int[255];
        for (int ch : s.toCharArray()) {
            if (pos[ch] != 0 && pos[ch] >= st) {
                ans = Math.max(ans, cu - st);
                st = pos[ch] + 1;
            }
            pos[ch] = cu;
            cu++;
        }
        ans = Math.max(ans, cu - st);
        return ans;
    }
}