class Solution {
    public int numDifferentIntegers(String word) {
        char[] temp = word.toCharArray();
        int i = 0, ans = 0, n = temp.length;
        // while(temp[i] < '0' || temp[i] > '9') i++;
        Set<String> hs = new HashSet();
        for(; i < n; i++) {
            if (temp[i] >= '0' && temp[i] <= '9') {
                // System.out.println(i);
                String tem = "";
                while(i<n && temp[i] == '0') i++;
                while(i < n && temp[i] >= '0' && temp[i] <= '9') {
                    tem += temp[i];
                    i++;
                }
                hs.add(tem);
            }
        }
        return hs.size();
    }
}