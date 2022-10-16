class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> hm = new HashSet();
        int max = -1;
        for (int i : nums) {
            if (hm.contains(-i)) max = Math.max(max, Math.abs(i));
            else hm.add(i);
        }
        return max;
    }
}