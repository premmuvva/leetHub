class Solution {
    public int lastRemaining(int n) {
        // if (n == 1) return 1;
        // return 
        int it = 0, ans = 1;
        boolean left = true;
        while (n != 1) {
            if ((n&1) == 1 || (it&1) == 0) {
                ans += (1 << it);
            }
            it++;
            n >>= 1;
        }
        return ans;
    }
}