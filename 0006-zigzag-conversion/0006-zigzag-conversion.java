class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        int si = s.length(), temp = 0;
        if(numRows == 1) return s;
        boolean flag;
        for (int i = numRows; i > 0; i--) {
            temp = numRows - i;
            flag = false;
            while(temp < si) {
                ans.append(s.charAt(temp));
                if (flag && (numRows - i) != 0) temp += (2 * (numRows - i));
                else if (i != 1) temp+= (2 * i - 2);
                else temp += (2 * numRows - 2);
                flag = !flag;
            }
        }
        return ans.toString();
    }
}