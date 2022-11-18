class Solution {
    public String reverseVowels(String s) {
        int st = 0, e = s.length() - 1, size = s.length();
        char temp, ans[] = s.toCharArray();

        while(st < e) {
            while (st < size && !isVowel(s.charAt(st))) st++;
            while (e >= 0 && !isVowel(s.charAt(e))) e--;
            if (st < e) {
                temp = ans[st];
                ans[st++] = ans[e];
                ans[e--] = temp;
            }
        }
        return new String(ans);
    }

    private boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'i':
            case 'e':
            case 'u':
            case 'o':
            case 'A':
            case 'I':
            case 'E':
            case 'U':
            case 'O':
            return true;
            default:
            return false;
        }
    }
}