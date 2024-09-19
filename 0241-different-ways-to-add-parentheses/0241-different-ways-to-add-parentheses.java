class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // int String[] arr = 
        int n = expression.length();
        
        return rec(expression, 0, n);
    }
    
    List<Integer> rec(String str, int i, int n) {
        // System.out.printf("%d %d\n", i, n);
        int ii = i;
        if (i >= n) return new ArrayList();
        List<Integer> ntemp = new ArrayList();
        if (i == n -1) {ntemp.add(str.charAt(i) - '0'); return ntemp;}
        if (i == n -2) {ntemp.add((str.charAt(i) - '0') * 10 + str.charAt(i+1) - '0'); return ntemp;}
        
        int cur;
        for (; i<n; i++) {
            cur = 0;
            while(i < n-1 && Character.isDigit(str.charAt(i))) {
                cur = cur * 10 + str.charAt(i) - '0';
                i++;
            }
            // if (i == n) {
            //     ntemp.add(cur);
            //     return ntemp;
            // }
            // cur = process(pre, cur, str.charAt(i));
            List<Integer> right = rec(str, i+1, n);
            List<Integer> left = rec(str, ii, i);
            char ch = str.charAt(i);
            // System.out.println(right);
            // System.out.println(left);
            for(int l: left)
                for (int r: right) {
                    ntemp.add(process(l, r, ch));
                }
            // pre = cur;
            // sign = str.charAt(i);
        }
        return ntemp;
    }
    
    int process(int cur, int te, char ch) {
        if (ch == '-') return cur - te;
        if (ch == '+') return cur + te;
        return cur * te;
    }
    
}