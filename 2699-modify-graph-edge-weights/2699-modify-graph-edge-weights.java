class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, List<Pair<Integer, Integer>>> hm = new HashMap();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] != -1) {
                hm.computeIfAbsent(edges[i][0], k -> new ArrayList()).add(new Pair(edges[i][1], edges[i][2]));
                hm.computeIfAbsent(edges[i][1], k -> new ArrayList()).add(new Pair(edges[i][0], edges[i][2]));
            }
        }
        
        int dd = rec(source, destination, target, hm, n); //destination distance
        if (dd == target) {
            setValue(edges, 2000000000);
            return edges;
        } else if (dd < target) return new int[0][0];
        for (int ar[] : edges) {
            if (ar[2] == -1) {
                ar[2] = 1;
                hm.computeIfAbsent(ar[0], k -> new ArrayList()).add(new Pair(ar[1], ar[2]));
                hm.computeIfAbsent(ar[1], k -> new ArrayList()).add(new Pair(ar[0], ar[2]));
                // System.out.println(hm);
                dd = rec(source, destination, target, hm, n);
                if (dd <= target) {
                    ar[2] += (target - dd);
                    setValue(edges, 2000000000);
                    return edges;
                }
            }
        }
        return new int[0][0];
    }
    void setValue(int[][] arr, int val) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i][2] == -1) {
                arr[i][2] = val;
            }
        }
    }
    int rec(int s, int d, int t, Map<Integer, List<Pair<Integer, Integer>>> hm, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{s, 0});
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[s]=0;
        
        while(!pq.isEmpty()) {
            
            int[] pqt = pq.poll();
            if (pqt[1] > dis[pqt[0]]) continue;
            if (hm.get(pqt[0]) == null) continue;
            for (Pair<Integer, Integer> pair: hm.get(pqt[0])) {
                if (pqt[1] + pair.getValue() < dis[pair.getKey()]) {
                    dis[pair.getKey()] = pqt[1] + pair.getValue();
                    pq.add(new int[]{pair.getKey(), dis[pair.getKey()]});
                }
            }
        }
        // System.out.println(Arrays.toString(dis));
        return dis[d];
    }
}