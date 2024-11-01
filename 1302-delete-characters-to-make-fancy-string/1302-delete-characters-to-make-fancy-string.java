class Solution {
    public String makeFancyString(String s) {
        char ch = s.charAt(0);
        int cu = 1;
        StringBuilder ans = new StringBuilder();
        ans.append(ch);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cu++;
            } else {
                System.out.println(s.charAt(i));
                cu = 1;
                ch = s.charAt(i);
            }
            if (cu <= 2) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}