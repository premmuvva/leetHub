class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> hm = new HashSet();
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (Math.abs(i) > max && hm.contains(-1 * i)) max = Math.abs(i);
            else hm.add(i);
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}