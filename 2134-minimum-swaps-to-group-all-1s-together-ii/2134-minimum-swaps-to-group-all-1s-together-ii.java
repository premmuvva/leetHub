class Solution {
    public int minSwaps(int[] nums) {
        int n1 = 0, i, t1 = 0, n = nums.length, max1 = 0;
        for (i = 0; i < n; i++) {
            if (nums[i] == 1) n1++;
        }
        
        for (i = 0; i < n1; i++) {
            if (nums[i] == 1) t1++;
        }
        max1 = t1;
        
        for (i = n1; i < n + n1; i++) {
            if (nums[i%n] == 1) t1++;
            if (nums[(i-n1) % n] == 1) t1--;
            max1 = Math.max(max1, t1);
        }
        
        return n1 - max1;
    }
}