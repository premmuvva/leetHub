class Solution {
    public String baseNeg2(int n) {
        
        if (n == 0) return "0";
        int rem = 0;
        StringBuilder ans = new StringBuilder();
        while(n != 0) {
            rem = n % 2;
            if (n < 0) {
                n--;
                ans.append(-rem);
            } else ans.append(rem);
            n = n / -2;
            
        }
        return ans.reverse().toString();
    }
}