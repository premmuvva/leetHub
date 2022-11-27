class Solution {
    public int pivotInteger(int n) {
        int tot = (n + 1) * n / 2;
        int temp = ((int) Math.sqrt(tot));
        return temp * temp == tot ? temp : -1;
    }
}