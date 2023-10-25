class Solution {
    public int kthGrammar(int n, int k) {
        k--; n--;
        boolean flag = true;
        while(n>=0) {
            int temp1 = k%2;
            if(temp1 == 1) flag = !flag;
            n = n - 1;
            k/=2;
            // System.out.printf("%d %s \n", k, flag);
        }
        // System.out.println();
        return flag ? 0 : 1;
    }
}