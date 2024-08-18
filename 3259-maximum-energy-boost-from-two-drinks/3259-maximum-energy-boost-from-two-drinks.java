class Solution {
    public long maxEnergyBoost(int[] aa, int[] bb) {
        long[] a = la(aa);
        long[] b = la(bb);
        long aans = 0, bans = 0;
        int n = a.length, ac = n - 1, bc = ac;

        a[1] = Math.max(a[0] + a[1], b[0]);
        b[1] = Math.max(b[0] + b[1], a[0]);

        for (int i = 2; i< n; i++) {
            a[i] = Math.max(a[i-1] + a[i], b[i-2] + a[i]);
            b[i] = Math.max(b[i-1] + b[i], a[i-2] + b[i]);
        }
        return Math.max(a[ac], b [ac]);
    }

    private long[] la(int[] intArray) {
        long[] longArray = new long[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            longArray[i] = (long) intArray[i];
        }
        return longArray;
    }
}