class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int len = arr.length, sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Long.compare(((long)a[1]) * b[0], ((long) b[1]) * a[0]));
        for (int i: arr) {
            pq.add(new int[]{i, 1});
        }
        n -= len;
        while(n > 0) {
            int[] poll = pq.poll();
            pq.offer(new int[]{poll[0], poll[1]+1});
            n--;
        }
        int poll[] = pq.peek();
        return (int) Math.ceil(((double) poll[0])/poll[1]);
    }
}