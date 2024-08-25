class Solution {
    // class Node {
    //     public Node left, right;
    //     public int val;
    //     public Node(int val) {
    //         this.val = val;
    //     }
    // }
    public long minimumFuelCost(int[][] roads, int seats) {
        
        int m = roads.length;
        if (m == 0) return 0L;
        int n = roads[0].length;
        Map<Integer, List<Integer>> hm = new HashMap();
        for (int i = 0; i< m; i++) {
            hm.computeIfAbsent(roads[i][0], k -> new ArrayList()).add(roads[i][1]);
            hm.computeIfAbsent(roads[i][1], k -> new ArrayList()).add(roads[i][0]);
        }
        // Queue<Integer> qu = new LinkedList();
        // int[] co = new int[m + 1];
        boolean[] vis = new boolean[m + 1];
        
        long[] ans = new long[1];
        rec(roads, vis, hm, seats, 0, ans);
        
        
        return ans[0];
        
    }
    
    int rec(int[][] arr, boolean[] vis,Map<Integer, List<Integer>> hm, int seats, int cur, long ans[]) {
//         if (vis[cur]) {
            
//         }
        vis[cur] = true;
        int tot = 1;
        for (int val: hm.get(cur)) {
            if (!vis[val])
                tot += rec(arr, vis, hm, seats, val, ans);
        }
        if (cur == 0) return 0;
        ans[0] += (int) Math.ceil(((float)tot)/seats);
        // System.out.printf("%d %d %d\n", cur, tot, ans[0]);
        return tot;
        
    }
}