class Solution {
    public boolean canSortArray(int[] nums) {
        Map<Integer, Integer> hm = new HashMap();
        int n = nums.length;
        for (int i = 0 ;i< n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], val(nums[i])));
        }
        // boolean ans = true;
        for (int i = 0; i<n+1; i++) {
            for (int j = 1; j<n-i; j++) {
                if (nums[j-1] > nums[j]) {
                    if (hm.get(nums[j-1]) == hm.get(nums[j])) {
                        int temp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        for (int j = 0; j<n-1; j++) {
            if (nums[j] > nums[j+1]) {
                return false;
            }
        }
        return true;
    }

    int val(int i) {
        int ans = 0;
        while(i>0) {
            ans += i%2;
            i/=2;
        }
        return ans;
    }
}