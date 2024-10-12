class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int pre = -1, arrival = times[targetFriend][0], n = times.length;
        // int a = times[targetFriend];
        Arrays.sort(times, (a, b) -> a[0]-b[0]);
        int ans = 0;
        PriorityQueue<Integer> available= new PriorityQueue();
        PriorityQueue<int[]> seated= new PriorityQueue<int[]>((a, b) -> a[0]-b[0]);

        for (int i = 0; i<=n; i++) available.offer(i);
        for(int i = 0; i<n; i++) {
            int arr = times[i][0], dep = times[i][1];
            while(!seated.isEmpty() && seated.peek()[0] <= arr) {
                available.offer(seated.poll()[1]);
            }
            if (arrival == arr) return available.poll();
            seated.offer(new int[]{dep, available.poll()});
        }
        return ans = 0;
    }
}