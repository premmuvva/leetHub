class Solution {
    public int[] sortArray(int[] nums) {
        // merge(nums, 0, nums.length-1);
        countingSort(nums);
        return nums;
    }
    
    void countingSort(int [] nums) {
        int n = nums.length;
        int sor[] = new int[100002];
        for (int i = 0; i < n; i++) sor[50000 + nums[i]]++;
        int cur = 0;
        for (int i = 0; i < 100002; i++) {
            while(sor[i]-- != 0) {
                nums[cur++] = i - 50000;
            }
        }
    }
    
    void merge(int[]nums, int st, int en) {
        // System.out.printf("%d %d\n", st, en);
        int stt= st, enn=en;
        if (st == en) return;
        if (st + 1 == en) {
            if (nums[st] > nums[en]) {
                swap(nums, st, en);
            }
            return;
        }
        int mid = st + (en - st)/2;
        merge(nums, st, mid);
        merge(nums, mid+1, en);
        mid++;
        while(st < mid && mid <= en) {
            if (nums[st] <= nums[mid]) {
                st++;
            } else {
                swap(nums, st++, mid);
                bubbleup(nums, mid, en);
                // System.out.printf("%d %d %s\n", stt, enn, Arrays.toString(nums));
            }
            if (st == mid) mid++;
        }
        // System.out.printf("%d %d %s\n", stt, enn, Arrays.toString(nums));
    }
    
    void bubbleup(int[] nums, int mid, int en) {
        while(mid < en && nums[mid] > nums[mid+1]) {
            swap(nums, mid, mid+1);
            mid++;
        }
    }
    void swap(int[] nums, int st, int en) {
        nums[st] = nums[st] ^ nums[en];
        nums[en] = nums[st] ^ nums[en];
        nums[st] = nums[st] ^ nums[en];
    }
    
    void sort(int[]nums, int st, int en) {
        if (st >= en) return;
        int piv = nums[en-1], si = st;
        for (int i = st; i<en-1; i++) {
            if (nums[i] < piv) {
                swap(nums, i, si++);
            }
        }
        swap(nums, en-1, si);
        // System.out.printf("%s %d %d\n", Arrays.toString(nums), nums[si], nums[en-1]);
        int tsi = si;
        while (tsi > 0 && nums[--tsi] == nums[si]);
        sort(nums, st, tsi-1);
        tsi = si+1;
        while (tsi < nums.length - 1 && nums[tsi++] == nums[si]);
        sort(nums, tsi, en);
    }
    
    // void swap (int[] nums, int i, int j) {
    //     int t = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = t;
    // }
}