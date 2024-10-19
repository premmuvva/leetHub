class Solution {
    public char findKthBit(int n, int k) {
        int val = (1<<n) - 1;
        int mid = val /2;
        if (mid == 0 || k == 1) return '0';
        if (k-1 == mid) return '1';
        else if (k <= mid) return findKthBit(n-1, k);
        return inverse(findKthBit(n-1, mid + 1 - (k - 1 - mid)));
    }

    private char inverse(char ch) {
        return ch == '1' ? '0' : '1';
    }
}