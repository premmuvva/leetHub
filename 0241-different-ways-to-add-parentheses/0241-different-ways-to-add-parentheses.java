class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return rec(expression, 0, n);
    }
    
    List<Integer> rec(String str, int i, int n) {
        int ii = i, cur;
        if (i >= n) return new ArrayList();
        List<Integer> ntemp = new ArrayList();
        if (i == n -1) {ntemp.add(str.charAt(i) - '0'); return ntemp;}
        if (i == n -2) {ntemp.add((str.charAt(i) - '0') * 10 + str.charAt(i+1) - '0'); return ntemp;}
        for (; i<n; i++) {
            cur = 0;
            while(i < n-1 && Character.isDigit(str.charAt(i))) {
                cur = cur * 10 + str.charAt(i) - '0';
                i++;
            }
            List<Integer> right = rec(str, i+1, n);
            List<Integer> left = rec(str, ii, i);
            char ch = str.charAt(i);
            for(int l: left)
                for (int r: right) {
                    ntemp.add(process(l, r, ch));
                }
        }
        return ntemp;
    }
    
    int process(int cur, int te, char ch) {
        if (ch == '-') return cur - te;
        if (ch == '+') return cur + te;
        return cur * te;
    }
    
}