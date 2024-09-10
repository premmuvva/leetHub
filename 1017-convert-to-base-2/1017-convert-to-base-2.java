class Solution {
    public String baseNeg2(int n) {
        
        if (n == 0) return "0";
        int rem = 0;
        String ans = "";
        while(n != 0) {
            rem = n % 2;
            if (n < 0) n--;
            n = n / -2;
            ans = Math.abs(rem) + ans;
        }
        return ans;
    }
}