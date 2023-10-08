class Solution {
    public int minProcessingTime(List<Integer> pt, List<Integer> ta) {
        // Collections.sort(pt);
        Collections.sort(ta, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(a, b));
        for(int i: pt) {
            pq.add(i);
            pq.add(i);
            pq.add(i);
            pq.add(i);
        }
        int ans = 0;
        for(int i : ta) {
            int temp = pq.poll() + i;
            // System.out.printf("%d %d %d\n", temp - i, i, pq.size());
            // pq.add(temp);
            ans = Math.max(ans, temp);
        }
            
        
        return ans;
    }
}