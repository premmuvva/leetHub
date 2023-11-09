class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0L, cou = 1;
        char ch;
        for(int i = 1; i<n; i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                cou++;
            } else {
                ch = s.charAt(i-1);
                ans += ((cou * (cou + 1))/2 % 1000000007);
                cou = 1;
            }
        }
        // hm.get(s.charAt(n-1)).merge(cou, 1, Integer::sum);
        ans += ((cou * (cou + 1))/2);
        
//         for(Map<Integer, Integer> hh: hm.values()) {
//             for(int ii: hh.values()) {
//                 ans += ((ii * (ii + 1))/2);
//             }
//         }
        return (int) (ans % 1000000007);
    }
}