class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        rec(candidates, target, new ArrayList(), 0, ans, 0);
        return ans;
    }
    
    private void rec(int[] arr, int target, List<Integer> cur, int curSum, List<List<Integer>> ans, int i) {
        // System.out.printf("%s %d\n", cur, curSum);
        for (; i < arr.length; i++) {
            cur.add(arr[i]);
            curSum += arr[i];
            if(curSum == target) {
                ans.add(new ArrayList(cur));
            } else if(curSum < target) {
                rec(arr, target, cur, curSum, ans, i);
            }
            curSum -= arr[i];
            cur.remove(cur.size() - 1);
        }
    }
}