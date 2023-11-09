class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0L, cou = 1;
        char ch;
        for(int i = 1; i<n; i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                cou++;
            } else {
                ch = s.charAt(i-1);
                ans = ((ans + ((cou * (cou + 1L))/2) % 1000000007L) % 1000000007L);
                cou = 1;
            }
        }
        ans += ((cou * (cou + 1))/2);
        return (int) (ans % 1000000007);
    }
}