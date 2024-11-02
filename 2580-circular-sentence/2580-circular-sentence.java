class Solution {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length(), i = 0;
        while(sentence.charAt(i++) == ' ');
        char pre, cur;
        while(i<n) {
            while(i < n && sentence.charAt(i) != ' ') {
                i++;
            }
            if (i == n)
                break;
            pre = sentence.charAt(i++ - 1);

            while(i < n && sentence.charAt(i) == ' ') {
                i++;
            }
            if (i == n)
                break;

            if (sentence.charAt(i) != pre) {
                return false;
            }

        }
        return sentence.charAt(0) == sentence.charAt(n-1);
    }
}