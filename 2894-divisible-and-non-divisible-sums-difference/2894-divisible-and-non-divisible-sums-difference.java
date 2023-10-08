class Solution {
    public int differenceOfSums(int n, int m) {
        int temp = n/m;
        return (((n + 1) * n)/2 - m * (temp * (temp +1) ));
    }
}