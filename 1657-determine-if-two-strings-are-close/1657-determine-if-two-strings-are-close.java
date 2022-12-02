class Solution {
    public boolean closeStrings(String word1, String word2) {
        int c[] = new int[130], c1[] = new int[130];
        for (char ch : word1.toCharArray()) {
            c[ch]++;
        }
        for (char ch: word2.toCharArray()) {
            c1[ch]++;
        }
        for (int i = 1; i < 130; i++) {
             if ((c[i] != 0 || c1[i] != 0) && (c[i] == 0 || c1[i] == 0)) return false;
        }
        Arrays.sort(c);
        Arrays.sort(c1);
        for (int i = 1; i < 130; i++) {
             if (c[i] != c1[i]) return false;
        }
        return true;
    }
}