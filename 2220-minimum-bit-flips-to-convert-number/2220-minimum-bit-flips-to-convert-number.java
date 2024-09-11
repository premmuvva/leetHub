class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        start ^= goal;
        while(start > 0) {
            ans += (start & 1);
            start = start >> 1;
        }
        return ans;
    }
}