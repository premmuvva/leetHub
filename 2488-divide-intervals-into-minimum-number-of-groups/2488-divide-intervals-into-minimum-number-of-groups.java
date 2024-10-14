class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        TreeMap<Integer, Integer> hm = new TreeMap();
        for (int[] arr: intervals) {
            hm.put(arr[0], hm.getOrDefault(arr[0], 0)+1);
            hm.put(arr[1]+1, hm.getOrDefault(arr[1]+1, 0) - 1);
        }
        int ans = 0, cur = 0;
        for (Map.Entry<Integer, Integer> en: hm.entrySet()) {
            cur += en.getValue();
            ans = Math.max(ans, cur);
        }
        // for (int i = 0; i<n;) {
        //     cur = 1;
        //     int np = intervals[i][1];
        //     while(i < n && intervals[i][0] <= np) {
        //         cur++;
        //         i++;
        //     }
        //     ans = Math.max(ans, cur);
        //     // pre = np;
        // }
        return ans;
    }
}