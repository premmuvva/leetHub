class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a-b);
        int n = s.length();
        List<Integer> index = new ArrayList();
        Set<Character> st = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for(int i = 0; i<n; i++) {
            if (st.contains(s.charAt(i))) {
                index.add(i);
                pq.add((int) s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder(s);
        for(int i : index) {
            ans.setCharAt(i, (char)(int)pq.poll());
        }
        return ans.toString();
    }
}