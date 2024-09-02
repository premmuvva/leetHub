class Solution {
    public int passThePillow(int n, int time) {
        int nn = 2 * (n - 1);
        int tn = time % nn;
        // if (tn == 0) return n;
        if (tn < n) return tn + 1;
        return 2*(n-1) - tn + 1;
    }
}