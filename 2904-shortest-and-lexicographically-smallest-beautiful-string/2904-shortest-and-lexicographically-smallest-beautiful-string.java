class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "23242342424233423231231213213123131231231231232132131321312131231213231232313213211322131223132112312", temp;
        int c = 0, n = s.length(), i = 0, pr = Integer.MAX_VALUE;
        List<Integer> dp = new ArrayList();
        while(i < n) {
            if(s.charAt(i) == '1') dp.add(i);
            i++;
        }
        int nn = dp.size();
        if(nn-k+1<=0) return "";
        ans = s.substring(dp.get(0), dp.get(k-1) + 1);
        for(i = 0; i<=nn-k; i++) {
            if(pr >= dp.get(i + k - 1) - dp.get(i)) {
                pr = dp.get(i + k - 1) - dp.get(i);
                temp = s.substring(dp.get(i), dp.get(i + k - 1) + 1);
                if(temp.length() < ans.length()) {
                    ans = temp;
                } else if(temp.length() == ans.length() && temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            // System.out.println
        }
        
//         if(c!=k) return "";
//         pr = s.indexOf('1', 0);
//         ans = s.substring(pr, i);
//         for(;i<n;i++) {
//             if(s.charAt(i) == '1') {
//                 pr = s.indexOf('1', pr+1);
//                 temp = s.substring(pr, i + 1);
//                 if(temp.length() <= ans.length() && temp.compareTo(ans) < 0) {
//                     ans = temp;
//                 }
                
//             }
//         }
        // pr = ans.indexOf('1', 0);
        // if(pr == -1) return "";
        return ans;
    }
}