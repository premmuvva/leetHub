class Solution {
    public boolean isPowerOfFour(int n) {
        // if (n == 1) return true;
        // n /= 4;
        if (n <= 0) return false;
        return Math.pow(4, (int)(Math.log(n)/Math.log(4))) == n;
        // while (n > 0) {
        //     if ((n&3) == 2 || (n&3) == 3 || ((n&3) == 1 && n/4 != 0)) return false;
        //     n = n >> 2;
        // }
        // return true;
    }
}