class Solution {
    public int[] dailyTemperatures(int[] temp) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);
        int n = temp.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            while(!pq.isEmpty() && pq.peek()[0] < temp[i]) {
                int[] tem = pq.poll();
                ans[tem[1]] = i - tem[1];
            }
            pq.offer(new int[]{temp[i], i});
        }

        return ans;
    }
}