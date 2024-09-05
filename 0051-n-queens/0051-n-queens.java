class Solution {
    public List<List<String>> solveNQueens(int n) {
        int r[] = new int[n], c[] = new int[n], d1[] = new int[2*n + 2], d2[] = new int[2*n + 2];
        Set<List<String>> ans = new HashSet();
        rec(n, r, c, d1, d2, 0, new ArrayList(), ans);
        return ans.stream().toList();
    }
    
    private void rec(int n, int[] r, int[] c, int[] d,int[] d2, int i, List<String> cur, Set<List<String>> ans) {
        if (cur.size() == n) {
            ans.add(new ArrayList(cur));
            // System.out.println(Arrays.toString(d2));
            return;
        }
        if (i == n) return;
        // if (i == 3) System.out.println(Arrays.toString(d2));
        for (int j = 0; j< n; j++) {
            if (c[j] == 1 || d[i-j+n] == 1 || d2[i+j] == 1) continue;
            c[j] = 1;
            d[i-j+n] = 1;
            d2[i+j] = 1;
            int ind = cur.size();
            String temp = ".".repeat(j) + 'Q' + ".".repeat(n-j-1);
            cur.add(temp);
            rec(n, r, c, d, d2, i+1, cur, ans);
            cur.remove(ind);
            c[j] = 0;
            d[i-j+n] = 0;
            d2[i+j] = 0;
        }
        return;
    }
}