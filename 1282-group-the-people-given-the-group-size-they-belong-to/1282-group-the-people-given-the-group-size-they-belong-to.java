class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> hm = new HashMap();
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!hm.containsKey(groupSizes[i])) {
                hm.put(groupSizes[i], new ArrayList());
            }
            hm.get(groupSizes[i]).add(i);
            if (hm.get(groupSizes[i]).size() == groupSizes[i]) {
                ans.add(hm.get(groupSizes[i]));
                hm.put(groupSizes[i], new ArrayList());
            }
        }
        return ans;
    }
}