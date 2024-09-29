class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() != split.length) return false;
        HashMap<Character, String> hm = new HashMap();
        HashMap<String, Character> hm2 = new HashMap();
        int i = 0, n = split.length;
        for (char ch: pattern.toCharArray()) {
            if (hm.containsKey(ch)) {
                if (!hm.get(ch).equals(split[i])) return false;
            } else {
                hm.put(ch, split[i]);
            }
            if (hm2.containsKey(split[i])) {
                if (!hm2.get(split[i]).equals(ch)) return false;
            } else {
                hm2.put(split[i], ch);
            }
            i++;
        }
        return true;
    }
}