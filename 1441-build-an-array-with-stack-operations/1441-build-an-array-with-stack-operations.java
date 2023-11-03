class Solution {
    public List<String> buildArray(int[] target, int nn) {
        int n = target.length, cu = 1, temp;
        List<String> ans = new ArrayList();
        for(int i = 0; i<n; i++) {
            if (cu != target[i]) {
                temp =  target[i] - cu;
                for(int ij = 0; ij < temp; ij++) {
                    ans.add("Push");
                    ans.add("Pop");
                }
            }
            ans.add("Push");
            cu = target[i] + 1;
        }
        return ans;
    }
}