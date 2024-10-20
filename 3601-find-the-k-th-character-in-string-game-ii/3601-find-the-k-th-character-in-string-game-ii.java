class Solution {
    public char kthCharacter(long k, int[] operations) {
        int val = 0, n = 0;
        while((1L << n) < k) n++;
        return (char) ((rec(n, k-1, operations) % 26) + 'a');
    }

    long rec(int n, long k, int[] operations) {
        if (n == 0) return 0;
        long mid = (1L<<(n-1));
        if (k < mid) return rec(n-1, k, operations);
        return ((long) operations[n-1]) + rec(n-1, k - mid, operations);
    }
}