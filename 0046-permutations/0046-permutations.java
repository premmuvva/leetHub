class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        rec(Arrays.stream(nums).boxed().toList(), new ArrayList(), ans);
        return ans;
    }
    
    private void rec(List<Integer> arr, List<Integer> cur, List<List<Integer>> ans) {
        // System.out.printf("%s %d\n", cur, curSum);
        if(arr.size() == 0) ans.add(new ArrayList(cur));
        for (int i = 0; i< arr.size(); i++) {
            cur.add(arr.get(i));
            List<Integer> tempArr = new ArrayList(arr);
            tempArr.remove(i);
            rec(tempArr, cur, ans);
            // arr.add(i);
            cur.remove(cur.size() - 1);
        }
    }
}