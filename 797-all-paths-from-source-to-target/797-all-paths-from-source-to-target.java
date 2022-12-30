class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList();
        temp.add(0);
        solve(ans, graph, 0, temp);
        return ans;
    }
    
    private void solve(List<List<Integer>> ans, int[][] arr, int i, List<Integer> temp) {
        for (int j : arr[i]) {
            temp.add(j);
            if (j == arr.length - 1) {
                ans.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
                continue;
            }
            solve(ans, arr, j, temp);
            temp.remove(temp.size()-1);
        }
    }
}