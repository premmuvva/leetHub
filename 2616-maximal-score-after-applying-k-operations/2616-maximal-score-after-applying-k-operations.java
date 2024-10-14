class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->b-a);
        pq.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        long ans = 0L;
        while(k-- > 0) {
            int val = pq.poll();
            pq.offer((val + 2)/3);
            ans += val;
        }
        return ans;
    }
}