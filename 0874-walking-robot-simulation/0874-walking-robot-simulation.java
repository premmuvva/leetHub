class Solution {
    public int robotSim(int[] cmd, int[][] obstacles) {
        int n = cmd.length, no = obstacles.length;
        Map<Integer, TreeSet<Integer>> hm = new HashMap();
        for (int i = 0; i<no; i++) {
            hm.computeIfAbsent(obstacles[i][0], k -> new TreeSet()).add(obstacles[i][1]);
        }
        // System.out.println(hm);
        int cx = 0, cy = 0, curd = 0;
        int posx[] = new int[]{0, -1, 0, 1};
        int posy[] = new int[]{1, 0, -1, 0};
        int tx, ty, ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (cmd[i] == -1) {
                curd = (curd + 3) % 4;
                continue;
            }
            if (cmd[i] == -2) {
                curd = (curd + 1) % 4;
                continue;
            }
            while(cmd[i] > 0) {
                tx = cx + posx[curd];
                ty = cy + posy[curd];
                if (hm.containsKey(tx) && hm.get(tx).contains(ty)) break;
                cx = tx;
                cy = ty;
                cmd[i]--;
            }
            ans = Math.max(ans, cx*cx + cy*cy);
            
        }
        return ans;
    }
}