class Solution {
    public long maxScore(int[] aa, int[] bb) {
        int n = bb.length;
        long[] a = new long[n], b = new long[n], c = new long[n], d = new long[n];
        b[0] = -10000000000000L;
        c[1] = -10000000000000L;
        d[2] = -10000000000000L;

        for (int i = 0; i<n-3; i++) {
            a[i] = i == 0 ? ((long)aa[0])*bb[i] : Math.max(a[i-1], ((long)aa[0])* bb[i]);
            b[i+1] = Math.max(b[i], a[i] + ((long)aa[1])*bb[i+1]);
            c[i+2] = Math.max(c[i+1], b[i+1] + ((long)aa[2])*bb[i+2]);
            d[i+3] = Math.max(d[i+2], c[i+2] + ((long)aa[3])*bb[i+3]);
        }
        return d[n-1];
    }
}