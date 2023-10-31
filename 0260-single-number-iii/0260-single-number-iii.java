class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> hs = new HashSet();
        int s = 0;
        for(int i : nums) {
            s^=i;
            hs.add(i);
        }
        for(int i:nums) {
            if(hs.contains(s^i)) {
                return new int[]{i, s^i};
            }
        }
        return new int[]{};
    }
}