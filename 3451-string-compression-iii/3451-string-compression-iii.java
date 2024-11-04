class Solution {
    public String compressedString(String word) {
        int n = word.length();
        char ch[] = new char[2 * n];
        int i = 0, cc = 1;
        for (int j = 0; j < n-1; j++) {
            if (word.charAt(j) == word.charAt(j+1)) {
                cc++;
                
            } else {
                while(cc >= 9) {
                    ch[i++] = '9';
                    ch[i++] = word.charAt(j);
                    cc -= 9;
                }
                if (cc > 0) {
                    ch[i++] = (char)(cc + '0');
                    ch[i++] = word.charAt(j);
                }
                cc = 1;
            }
        }
        while(cc >= 9) {
            ch[i++] = '9';
            ch[i++] = word.charAt(n-1);
            cc -= 9;
        }
        if (cc > 0) {
            ch[i++] = (char)(cc + '0');
            ch[i++] = word.charAt(n-1);
        }
        return new String(ch, 0, i);
    }
}