class Solution {
    public int[] findArray(int[] pref) {
        int i = pref.length - 1;
        for(; i>0; i--) {
            pref[i] ^= pref[i-1];
        }
        return pref;
    }
}