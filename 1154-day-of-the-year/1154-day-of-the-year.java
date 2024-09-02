class Solution {
    public int dayOfYear(String date) {
        int ans = 0;
        String sp[] = date.split("-");
        int mo = Integer.parseInt(sp[1]), yy = Integer.parseInt(sp[0]);
        int[] prefix = new int[]{0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        ans += (prefix[mo] + Integer.parseInt(sp[2]));
        if (mo <= 2) return ans;
        if (yy % 4 == 0 && (yy %100 != 0 || yy % 400 == 0)) return ans + 1;
        return ans;
    }
}