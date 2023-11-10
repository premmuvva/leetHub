class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> hm = new HashMap();
        for (int [] ar: adjacentPairs) {
            if(!hm.containsKey(ar[0])) hm.put(ar[0], new ArrayList());
            if(!hm.containsKey(ar[1])) hm.put(ar[1], new ArrayList());
            hm.get(ar[0]).add(ar[1]);
            hm.get(ar[1]).add(ar[0]);
        }
        int[] ans = new int[hm.size()];
        int i = 0, pr = 0, cu = 0;
        for(Map.Entry<Integer, List<Integer>> ar: hm.entrySet()) {
            if(ar.getValue().size() == 1) {
                ans[i++] = ar.getKey();
                ans[i++] = ar.getValue().get(0);
                pr = ar.getKey();
                cu = ar.getValue().get(0);
                break;
            }
        }
        while(hm.get(cu).size() != 1) {
            if(hm.get(cu).get(0) == pr) {
                ans[i++] = hm.get(cu).get(1);
                pr = cu;
                cu = hm.get(cu).get(1);
            } else {
                ans[i++] = hm.get(cu).get(0);
                pr = cu;
                cu = hm.get(cu).get(0);
            }
        }
        return ans;
    }
}