class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hs = new HashSet();
        int s = 0;
        for (int i : nums) {
            hs.add(i);
            s = 0;
            while(i > 0) {
                s = (10 * s + i% 10);
                i /= 10;
            }
            hs.add(s);
        }
        return hs.size();
    }
}