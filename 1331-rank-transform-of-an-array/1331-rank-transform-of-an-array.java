class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> hm = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            hm.computeIfAbsent(arr[i], k -> new ArrayList()).add(i);
        }
        int i = 1;
        for (Map.Entry<Integer, List<Integer>> entry: hm.entrySet()) {
            for(int ii : entry.getValue()) {
                arr[ii] = i;
            }
            i++;
        }
        return arr;
    }
}