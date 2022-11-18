class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1, c;
        while (--n > 0) {
            c = b;
            b = a + b;
            a = c;
        }
        return b;
    }
}