class Solution {
    public List<String> stringSequence(String target) {
        List<String> str = new ArrayList();
        int n = target.length();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i<n; i++) {
            int ch = 'a';
            for (int j = ch; j <= target.charAt(i); j++) {
                str.add(cur.toString() + (char) j);
            }
            cur.append(target.charAt(i));
        }
        return str;
    }
}