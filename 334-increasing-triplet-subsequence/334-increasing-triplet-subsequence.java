class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int a = nums[0], b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        boolean bset = false, cset = false;
        for (int i = 1; i < nums.length; i++) {
            if (cset && nums[i] > c) {
                if (!bset) {
                    b = Math.max(nums[i], c);
                    a = Math.min(nums[i], c);
                    cset = false;
                    continue;
                }
                if (b < nums[i]) return true;
                else {
                    cset = false;
                    a = c;
                    b = nums[i];
                    continue;
                }
            }
            if (nums[i] > a) {
                if (!bset) {
                    b = nums[i];
                    bset = true;
                } else if (nums[i] <= b) {
                    b = nums[i];
                } else {
                    return true;
                }
            } else if (nums[i] < a) {
                if (!bset) {
                    a = nums[i];
                    continue;
                }
                if (cset && c < nums[i]) continue;
                c = nums[i];
                cset = true;
            }
        }
        return false;
    }
}