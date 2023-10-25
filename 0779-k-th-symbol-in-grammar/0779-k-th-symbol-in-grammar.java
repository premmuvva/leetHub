class Solution {
    public int kthGrammar(int n, int k) {
        k--; n--;
        boolean flag = true;
        while(n>=0) {
            if(k%2 == 1) flag = !flag;
            n = n - 1;
            k/=2;
        }
        return flag ? 0 : 1;
    }
}