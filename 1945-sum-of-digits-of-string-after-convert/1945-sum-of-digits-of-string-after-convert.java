class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9};
        for (char ch: s.toCharArray()) {
            ans += arr[ch-'a'];
        }
        // System.out.printf("%d %d\n", 'a' + 1, ans);
        // ans -= s.length() * ('a' + 1);
        // System.out.printf("%d %d\n", 'a' + 1, ans);
        int fa = ans;
        while (k > 1) {
            ans = fa;
            fa = 0;
            while(ans > 0) {
                fa += ans % 10;
                ans /= 10;
            }
            k--;
        }
        return fa;
    }
}
