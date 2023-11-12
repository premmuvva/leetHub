class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int aa = nums1[n-1], bb = nums2[n-1];
        int a = Math.max(aa, bb), b = Math.min(aa, bb);
        int ans = aa < bb ? 1 : 0, si = 0;
        for(int i = 0; i<n-1; i++) {
            if((nums1[i] > b && nums2[i] > b) || (nums1[i] > a) || (nums2[i] > a)) {
                return -1;
            }
            if(nums1[i] <= a && nums2[i] <= b) {
                if(nums1[i] == nums2[i]) si++;
                continue;     
            } 
            ans++;
        }
        return Math.min(ans, n - ans - si);
    }
}