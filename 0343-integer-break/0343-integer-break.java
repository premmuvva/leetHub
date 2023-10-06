class Solution {
    public int integerBreak(int n) {
        int ans = 0, temp;
        for (int i = 1; n/i > 0; i++) {
            temp = (int)Math.pow(i, n/i) * (n - (n/i)*i);
            // System.out.println(Math.pow(i, n/i - 1) );
            // System.out.println(n - (n/i - 1)*i);
            // System.out.println(n/i);
            // System.out.println("");
            ans = Math.max(ans, temp);
            if(n/i - 1 > 0)
                temp = (int)Math.pow(i, n/i - 1) * (n - (n/i - 1)*i);
                ans = Math.max(ans, temp);
        }
        
        return ans;
    }
}