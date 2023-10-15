class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int i = 0, n = nums.length, min = nums[0], max = nums[0], mi = 0, mai = 0;
        int ii = 0;
        for(i=indexDifference; i<n; i++, ii++) {
            
            if(min > nums[ii]) {
                min = nums[ii];
                mi = ii;
            } 
            
            if(max < nums[ii]) {
                max = nums[ii];
                mai = ii;
            } 
            
            if(Math.abs(nums[i] - min) >= valueDifference) {
                return new int[]{mi, i};
            }
            if(Math.abs(nums[i] - max) >= valueDifference) {
                return new int[]{mai, i};
            }
            
        }
        return new int[]{-1, -1};
    }
}