class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length - 1, zc = 0;
        // Queue<Integer> qu = new LinkedList();
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 0) {
        //         qu.add(i);
        //         zc++;
        //         continue;
        //     }
        //     if (nums[i] == nums[i+1]) {
        //         if (qu.isEmpty()) nums[i] *= 2;
        //         else {
        //             nums[qu.remove()] = nums[i] * 2;
        //             qu.add(i);
        //         }
        //         qu.add(++i);
        //         zc++;
        //     }
        // }
        for (int i = 0; i<n; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        n++;
        for (int i = 0; i < n;i++) {
            if (nums[i] != 0) nums[zc++] = nums[i];
        }
        for (int i = zc; i<n; i++) nums[i] = 0;
        return nums;
    }
}