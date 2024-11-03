class Solution {
    public boolean rotateString(String s, String goal) {
        int i = 0, n = s.length(), m = goal.length();
        if (n != m) return false;
        List<Character> a1 = toList(s);
        List<Character>  a2 = toList(goal);
        for (i = 0; i<n; i++) {
            a2.add(a2.get(0));
            a2.remove(0);
            if (a1.equals(a2)) return true;
        }
        return false;
    }

    List<Character> toList(String s) {
        List<Character> ans = new ArrayList();
        for (char ch: s.toCharArray()) {
            ans.add(ch);
        }
        return ans;
    }
}