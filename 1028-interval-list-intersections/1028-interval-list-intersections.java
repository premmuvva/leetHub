class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Map<Integer, Integer> hm = new TreeMap();
        for (int[] i: firstList) {
            hm.put(i[0], hm.getOrDefault(i[0], 0) + 1);
            hm.put(i[1]+1, hm.getOrDefault(i[1]+1, 0) - 1);
        }
        for (int[] i: secondList) {
            hm.put(i[0], hm.getOrDefault(i[0], 0) + 1);
            hm.put(i[1]+1, hm.getOrDefault(i[1]+1, 0) - 1);
        }

        int cur = 0, start = 0;
        boolean st = false;
        List<int[]> ans = new ArrayList();
        for (Map.Entry<Integer, Integer> en: hm.entrySet()) {
            cur += en.getValue();
            if(st) {
                st = false;
                ans.add(new int[]{start, en.getKey() - 1});
            }
            if (cur > 1) {
                if (!st) {
                    st = true;
                    start = en.getKey();
                }
            }
        }
        return ans.toArray(new int[0][0]);
    }
}