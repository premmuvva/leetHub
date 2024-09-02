class Solution {
    public int passThePillow(int n, int time) {
        int nn = 2 * (n - 1);
        int tn = time % nn;
        if (tn < n) return tn + 1;
        return nn - tn + 1;
    }
}