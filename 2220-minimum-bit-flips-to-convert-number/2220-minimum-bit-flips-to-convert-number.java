class Solution {
    public int minBitFlips(int start, int goal) {
        start ^= goal; //reusing start for xor and goal for ans
        goal = 0;
        while(start > 0) {
            goal ++;
            start = (start - 1) & start;
        }
        return goal;
    }
}