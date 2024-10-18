class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, ans = 0;
        int values = (1 << (n)) -1, max = 0;
        for (int i = 0; i < n; i++) {
            max |= nums[i];
        }
        for (int i = 0; i<=values; i++) {
            int temp = 0;
            for (int j = 0; j<17; j++) {
                if (((1<< j) & i ) > 0) {
                    temp |= nums[j];
                    if (temp == max) {
                        ans ++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}