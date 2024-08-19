class Solution {
    public int minSteps(int n) {
        int ans = 0, cur = 2;
        while (n > 1) {
            while(n % cur == 0) {
                ans += cur;
                n /= cur;
            }
            cur ++;
            // if ((n & 1) == 1) {
            //     n--;
            //     ans++;
            // } else {
            //     n/=2;
            //     ans+=2;
            // }
            // System.out.println(n);
        }
        return ans;
    }
}