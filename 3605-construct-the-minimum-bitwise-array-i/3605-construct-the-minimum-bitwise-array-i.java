class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n= nums.size(), i = 0;
        int[] ans = new int[n];
        boolean flag = false;
        for (int num: nums) {
            if ((num & 1) != 1) ans[i++] = -1;
            else {
                flag = false;
                for (int j= 0; j<1000; j++) {
                    if ((j | (j+1)) == num) {
                        ans[i++] = j;
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    ans[i++] = -1;
            }
        }
        return ans;
    }
}