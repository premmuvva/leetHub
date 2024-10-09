class Solution {
    public int maxGoodNumber(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2], i = nums[0];
        int n = 3;
        int ans = 0;
        ans = Math.max(ans, perm(a, b, c));
        ans = Math.max(ans, perm(a, c, b));
        ans = Math.max(ans, perm(b, a, c));
        ans = Math.max(ans, perm(b, c, a));
        ans = Math.max(ans, perm(c, a, b));
        ans = Math.max(ans, perm(c, b, a));
        return ans;
    }

    int perm(int a , int b, int c ) {
        return val(bin(a) + bin(b) + bin(c));
    }
    int val(String s) {
        int ans =0;
        for(char ch: s.toCharArray()) {
            ans = ans * 2 + ch -'0';
        }
        return ans;
    }

    String bin(int i) {
        String aa = "";
        while(i > 0) {
            aa = String.valueOf(i%2) + aa;
            i /= 2;
        }
        return aa;
    }

}