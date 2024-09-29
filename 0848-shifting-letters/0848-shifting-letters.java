class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length(), arr[] = new int[n];
        StringBuilder str = new StringBuilder();
        int cc = 0;
        for (int i=n -1; i>=0; i--) {
            cc = (cc + shifts[i]) % 26;
            str.append((char) ((s.charAt(i) - 'a' + cc)%26 + 'a'));
        }
        return str.reverse().toString();
    }
}