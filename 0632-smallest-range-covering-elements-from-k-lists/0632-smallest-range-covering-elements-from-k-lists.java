class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)-> a[0] - b[0]);
        int n = nums.size(), max = Integer.MIN_VALUE;
        for (int i = 0; i< n; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i, 0, nums.get(i).size()});
            max = Math.max(max, nums.get(i).get(0));
        }
        int ans[] = {pq.peek()[0], max}, best = max-pq.peek()[0];
        while(true) {
            int[] poll = pq.poll();
            if (++poll[2] == poll[3]) {
                return ans;
            }
            int temp = nums.get(poll[1]).get(poll[2]);
            max = Math.max(temp, max);
            pq.offer(new int[]{temp, poll[1], poll[2], poll[3]});
            if(max-pq.peek()[0] < best) {
                best = max-pq.peek()[0];
                ans = new int[]{pq.peek()[0], max};
            }
        }
        // return ans;
    }
}