class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = 0, right = m;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        
        while (left <= right) {
            int lp = (left + right)/2, rp = (m+n+1)/2 - lp;
            int maxleftA = (lp == 0) ? Integer.MIN_VALUE : nums1[lp - 1];
            int minrightA = (lp == m) ? Integer.MAX_VALUE : nums1[lp];
            int maxleftB = (rp == 0) ? Integer.MIN_VALUE : nums2[rp-1];
            int minleftB = (rp == n) ? Integer.MAX_VALUE : nums2[rp];
            
            if (maxleftA > minleftB) right = lp - 1;
            else if (maxleftB > minrightA) left = lp + 1;
            else {
                if (((m+n)&1) == 1) return Math.max(maxleftA, maxleftB);
                return (Math.min(minrightA, minleftB) + Math.max(maxleftA, maxleftB))/2.0;
            }
        }
        return -1;
    }
}