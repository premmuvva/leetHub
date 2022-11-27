class Solution {
    public int pivotInteger(int n) {
        int tot = (n + 1) * n / 2;
        int temp = (-2+ (int) Math.sqrt(4 + 4 * tot - 4 ))/2;
        return temp * (temp + 1) == tot - temp - 1 ? temp + 1 : -1;
    }
}