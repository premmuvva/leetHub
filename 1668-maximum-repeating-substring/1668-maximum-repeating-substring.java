class Solution {
    public int maxRepeating(String sequence, String word) {
        final StringBuilder ans = new StringBuilder();
        while(sequence.indexOf(ans.toString()) >= 0) ans.append(word);
        // ans.to
        return (ans.length() - word.length()) / word.length();
    }
}