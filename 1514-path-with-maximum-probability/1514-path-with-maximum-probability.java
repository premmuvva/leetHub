class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Integer[]>> hm = new HashMap();
        for (int i = 0; i<edges.length; i++) {
            int ar[] = edges[i];
            hm.computeIfAbsent(ar[0], k -> new ArrayList<Integer[]>()).add(new Integer[]{i, ar[1]});
            hm.computeIfAbsent(ar[1], k -> new ArrayList<Integer[]>()).add(new Integer[]{i, ar[0]});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a, b) -> (Double.compare(b[0], a[0])));
        pq.add(new double[]{1, start_node});
        double[] temp;
        Map<Integer, Double> pro = new HashMap();
        pro.put(start_node, 1.00);
        double prod;
        while(!pq.isEmpty()) {
            temp = pq.poll();
            if ((int)temp[1] == end_node) return temp[0];
            // System.out.println(temp[1]);
            if (!hm.containsKey((int) temp[1])) continue;
            for (Integer[] arr: hm.get((int)temp[1])) {
                prod = temp[0] * succProb[arr[0]];
                if (!pro.containsKey(arr[1]) || prod > pro.get(arr[1])) {
                    pro.put(arr[1], prod);
                    pq.add(new double[]{prod, arr[1]});
                }
            }
        }
        
        return pro.containsKey(end_node) ? pro.get(end_node): 0.00;
    }
    
    double rec(Map<Integer, List<Integer[]>> hm , boolean[] vis, int st, int en, double[] succProb) {
        if (st == en) {
            return 1;
        }
        double ans = 0.0;
        if (!hm.containsKey(st)) return ans;
        for (Integer[] i : hm.get(st)) {
            if (vis[i[1]]) continue;
            vis[i[1]] = true;
            ans = Math.max(ans, succProb[i[0]] * rec(hm, vis, i[1], en, succProb));
            vis[i[1]] = false;
        }
        // System.out.printf("%d %d %f\n", st, en, ans);
        return ans;
    }
}