class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int st = 0, en = 0;
        long ans = 0L;
        while(st < n) {
            if (s.charAt(st) == '0') {
                ans += (st - en++);
            }
            st++;
        }
        return ans;
    }
}