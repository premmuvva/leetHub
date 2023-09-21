
class Solution {
public:
    
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n=(nums1.size()+nums2.size())/2,a1=0,b1=0;
        nums1.push_back(INT_MAX);
        nums2.push_back(INT_MAX);
        if(nums1.size()+nums2.size()&1){
            while((a1+b1)!=n){
                if(nums1[a1]>nums2[b1]) b1++;
                else a1++;
            }
            return nums1[a1]>nums2[b1]? nums2[b1] : nums1[a1];
        }
        while((a1+b1)!=n-1){
            if(nums1[a1]>nums2[b1]) b1++;
            else a1++;
        }
        return ((nums1[a1]>nums2[b1]? nums2[b1++] : nums1[a1++]) + (nums1[a1]>nums2[b1]? nums2[b1] : nums1[a1]))/2.0;
    }
};