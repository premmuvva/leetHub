class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> hs = new HashSet(Arrays.asList(bannedWords));
        int i = 0;
        for (String str: message) {
            if (hs.contains(str)) {
                i++;
                if (i == 2) return true;
            }
        }
        return false;
    }
}