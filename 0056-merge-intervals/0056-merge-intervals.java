class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> hm = new TreeMap();
        for(int i[]: intervals) {
            hm.put(i[0], hm.getOrDefault(i[0], 0) + 1);
            hm.put(i[1], hm.getOrDefault(i[1], 0) - 1);
        }
        int cur = 0, st = hm.firstEntry().getKey();
        boolean first = true;
        List<int[]> ans = new ArrayList();
        for (Map.Entry<Integer, Integer> en: hm.entrySet()) {
            if (first) {
                st = en.getKey();
            }
            cur += en.getValue();
            if (cur == 0) {
                ans.add(new int[]{st, en.getKey()});
                first = true;
            } else {
                first = false;
            }
        }
        return ans.toArray(new int[0][0]);
    }
}