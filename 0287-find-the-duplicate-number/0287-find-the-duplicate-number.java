class Solution {
    public int findDuplicate(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> dp = new HashMap();
        for (int i : nums) if(dp.containsKey(i)) return i; else dp.put(i, i);
        return 0;
    }
}