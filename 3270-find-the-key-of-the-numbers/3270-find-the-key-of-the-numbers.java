class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int i = 0, ans = 0;
        while (i < 4) {
            ans += Math.pow(10, i) * Math.min(Math.min(num1%10, num2%10), num3%10);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
            i++;
        }
        return ans;
    }
}