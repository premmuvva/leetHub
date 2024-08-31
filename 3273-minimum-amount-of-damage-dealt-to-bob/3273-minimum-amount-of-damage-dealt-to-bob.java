class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (a, b) -> Double.compare((((double)b[0])/b[1]), (((double)a[0])/a[1]))
            );
        int n = damage.length, tot = 0;
        for (int i = 0; i<n; i++) {
            pq.offer(new int[]{damage[i], (int) Math.ceil(((double)health[i])/power)});
            tot += damage[i];
        }
        int[] t;
        long ans = 0;
        // for (int[] ar: pq) {
        //     System.out.println(Arrays.toString(ar));
        // }
        while(!pq.isEmpty()) {
            t = pq.poll();
            ans += (t[1] * tot);
            tot -= t[0];
        }
        return ans;
    }
}