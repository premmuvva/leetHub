class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        final List<Integer> ans = new ArrayList();
        for(int i = 0; i< words.length; i++) {
            if (words[i].lastIndexOf(x) != -1) ans.add(i);
        }
        return ans;
    }
}