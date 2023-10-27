class Solution {
    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> hm = new HashMap();
        int n = s.length(), nn = -1, m, ii, j, jj;
        String ans = s.substring(0, 1);
        char ch;
        for(int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if(!hm.containsKey(ch)) {
                hm.put(ch, new ArrayList());
            }
            hm.get(ch).add(i);
        }
        
        for(int i = 0; i < n; i++) {
            ch = s.charAt(i);
            m = hm.get(ch).size();
            while(m-- != 0) {
                ii = i;
                jj = hm.get(ch).get(m);
                for(j = jj; ii <= j && s.charAt(ii) == s.charAt(j); ii++, j--) {
                }
                if(ii > j) {
                    if(jj - i > nn) {
                        ans = s.substring(i, jj + 1);
                        nn = jj - i;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}