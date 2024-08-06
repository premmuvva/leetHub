class Solution {
    public int minimumPushes(String word) {
        int hm[] = new int[27];
        for (char ch: word.toCharArray()) {
            hm[ch - 'a']++;
        }
        Arrays.sort(hm);
        int i = 26, ans = 0;
        for (; i >= 19; i--) {
            ans += hm[i];
        }
        for (; i >= 11; i--) {
            ans += (hm[i] * 2);
        }
        for (; i >= 3; i--) {
            ans += (hm[i] * 3);
        }
        for (; i >= 0; i--) {
            ans += (hm[i] * 4);
        }
        return ans;
    }
}