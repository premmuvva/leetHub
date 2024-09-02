class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long []ps = new long[n];
        ps[0] = chalk[0];
        for (int i = 1; i<n; i++) {
            ps[i] = ps[i-1] + chalk[i];
        }
        k = (int) (k % ps[n-1]);
        int mid = 0;
        int st = 0, en = n-1;
        while (st < en) {
            mid = st + (en - st)/2;
            if (ps[mid] > k) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}