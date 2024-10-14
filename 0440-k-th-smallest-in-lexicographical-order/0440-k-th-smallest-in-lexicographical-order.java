class Solution {
    public int findKthNumber(int n, int k) {
        k--;
        // if (k == 0) 
        int count = 0, i = 1;
        while (k > 0) {
            count = rec(i, i+1, n);
            if (count <= k) {
                k -= count;
                i++;
            } else {
                i *= 10;
                k--;
            }
        }
        return i;
    }
    
    int rec(long st, long en, int n) {
        int ans = 0;
        while(st <= n) {
            ans += Math.min(en, n+1) - st;
            en *= 10;
            st *= 10;
        }
        return ans;
    }
}