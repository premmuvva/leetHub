class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.merge(i, 1, Integer::sum);
        }
        
        int ans = 0;
        for (int i : hashMap.keySet()) {
            ans += hashMap.get(i) * (hashMap.get(i) - 1 ) / 2;
        }
        
        return ans;
    }
}