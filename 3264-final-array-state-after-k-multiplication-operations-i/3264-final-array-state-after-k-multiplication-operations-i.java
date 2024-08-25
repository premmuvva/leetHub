class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> arr = new PriorityQueue<int[]>((a, b) -> {
            int result = a[0] - b[0];
            return result == 0 ? a[1] - b[1] : result;
    });
        int n = nums.length;
        for (int i = 0; i<n; i++) {
            arr.offer(new int[]{nums[i], i});
        }
        int[] temp;
        for (int i = 0; i<k; i++) {
            temp = arr.poll();
            arr.offer(new int[]{temp[0] * multiplier, temp[1]});
        }
        while(!arr.isEmpty()) {
            temp = arr.poll();
            nums[temp[1]] = temp[0];
        }
        return nums;
    }
}