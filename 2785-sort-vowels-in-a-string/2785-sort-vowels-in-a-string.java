class Solution {
    public String sortVowels(String s) {
        List<Character> pq = new ArrayList();
        int n = s.length();
        List<Integer> index = new ArrayList();
        Set<Character> st = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for(int i = 0; i<n; i++) {
            if (st.contains(s.charAt(i))) {
                index.add(i);
                pq.add(s.charAt(i));
            }
        }
        Collections.sort(pq);
        int co = 0;
        StringBuilder ans = new StringBuilder(s);
        for(int i : index) {
            ans.setCharAt(i, pq.get(co++));
        }
        return ans.toString();
    }
}