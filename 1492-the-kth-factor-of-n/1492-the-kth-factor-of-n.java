class Solution {
    public int kthFactor(int n, int k) {
        int t = 1;
        if(k == 1) return 1;
        for(int i = 2; i <= (n+1)/2; i++) {
            if(n % i == 0) {
                t++;
                if(t == k) return i;
            }
        }
        return t+1 == k ? n : -1;
    }
}