class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList();
        // ans.add(1);
        rec(ans, n, 1);
        return ans;
    }
    
    void rec(List<Integer> ans, int n, int cur) {
        if (n < cur) return;
        else ans.add(cur);
        if (cur * 10 <= n) {
            // ans.add(cur*10);
            rec(ans, n, cur*10);
        }
        while (cur % 10 < 9 && cur + 1 <= n) {
            ans.add(++cur);
            rec(ans, n, cur*10);
        }
        return;
    }
}