class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList();
        temp.add(1);
        ans.add(temp);
        for (int i = 1; i < numRows; i++) {
            temp = new ArrayList();
            temp.add(1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(ans.get(i-1).get(j) + ans.get(i-1).get(j+1));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}