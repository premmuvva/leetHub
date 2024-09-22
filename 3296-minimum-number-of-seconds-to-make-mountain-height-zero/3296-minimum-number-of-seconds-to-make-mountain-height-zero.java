class Solution {
    public long minNumberOfSeconds(int h, int[] ti) {
        int n = ti.length;
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0],b[0]));
        for (int i =0; i<n; i++) pq.add(new long[]{ti[i], ti[i], 2});
        long ii[], ans = 0;
        while(h-- > 0) {
            ii = pq.poll();
            ans = Math.max(ii[0], ans);
            pq.add(new long[]{ii[0] + ii[1] * ii[2], ii[1], ii[2] + 1});
        }
        return ans;
    }
}