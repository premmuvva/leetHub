class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder("a");
        // int i = 0;
        int cc = 1;
        if (k == 1) return 'a';
        while (true) {
            int len = str.length();
            for(int i = 0; i<len; i++ ) {
                char ch = str.charAt(i);
                // System.out.println(ch);
                str.append((char)((ch - 'a' + 1) % 26 + 'a'));
                cc++;
                if (cc == k) {
                    // System.out.println(str);
                    return (char) (ch + 1);
                }
            }
            // i++;
        }
        // return 'a';
    }
}