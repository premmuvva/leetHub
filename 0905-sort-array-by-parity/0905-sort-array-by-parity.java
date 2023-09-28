class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j = 0, temp;
        for(int i = 0; i<nums.length; i++) {
            if((nums[i] & 1) == 0) {
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }
}