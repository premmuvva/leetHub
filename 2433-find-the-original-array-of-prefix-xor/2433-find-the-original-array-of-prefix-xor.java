class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length, temp = 0, temp1;
        for(int i = 0; i<n; i++) {
            temp1 = temp ^ pref[i];
            temp = pref[i];
            pref[i] = temp1;
        }
        return pref;
    }
}