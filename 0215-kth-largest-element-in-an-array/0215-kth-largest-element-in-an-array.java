class Solution {
    public int findKthLargest(int[] nums, int k) {
        return rec(nums, 0, nums.length - 1, k-1);
    }

    int rec(int[]nums, int st, int en, int k) {
        int pivot = nums[en];
        if (st == en && st == k) return pivot;
        int cur = en-1, i = st;
        while(cur > i) {
            if (nums[i] < pivot) {
                swap(nums, i, cur--);
            } else {
                i++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        if (nums[cur] < pivot) swap(nums, cur, en);
        else swap(nums, ++cur, en);
        if (cur == k) return pivot;
        // if (cur < k) rec()

        // while(cur > i) {
        //     if (nums[i] < pivot) {
        //         swap(nums, i, cur--);
        //     } else 
        //     i++;
        // }
        // if (nums[cur] >= pivot)
        //     swap(nums, i, en);
        // else swap(nums,++i, en);
        // if (i == k) return pivot;
        // System.out.println(Arrays.toString(nums));
        // System.out.printf("%d %d %d %d\n", st, en, cur, i);
        if (cur < k) return rec(nums, cur+1, en, k);
        return rec(nums, st, cur-1, k);
    }

    void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}