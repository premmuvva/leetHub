class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>(
            (a, b) -> Double.compare((((double)b[0])/b[1]), (((double)a[0])/a[1]))
            );
        int n = damage.length, tot = 0;
        for (int i = 0; i<n; i++) {
            pq.offer(new long[]{damage[i], (long)Math.ceil(((double)health[i])/power)});
            tot += damage[i];
        }
        long[] t;
        long ans = 0;
        while(!pq.isEmpty()) {
            t = pq.poll();
            ans += (t[1] * tot);
            tot -= t[0];
        }
        return ans;
    }
}