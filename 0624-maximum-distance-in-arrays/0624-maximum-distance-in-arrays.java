class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0, a = Integer.MAX_VALUE, b = Integer.MIN_VALUE;
        for (List<Integer> arr : arrays) {
            int size = arr.size();
            if (a != Integer.MAX_VALUE) {
                ans = Math.max(ans, Math.abs(b - arr.get(0)));
                ans = Math.max(ans, Math.abs(a - arr.get(size-1)));
            }
            a = Math.min(a, arr.get(0));
            b = Math.max(b, arr.get(size -1));
        }
        return ans;
    }
}