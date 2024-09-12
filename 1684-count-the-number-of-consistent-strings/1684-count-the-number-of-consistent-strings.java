class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean flag, arr[] = new boolean[255];
        for (char ch: allowed.toCharArray()) {
            arr[ch] = true;
        }
        int ans = 0;
        for (String str: words) {
            flag = true;
            for (char ch: str.toCharArray()) {
                if(!arr[ch]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}