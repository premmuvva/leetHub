class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList(), temp = new ArrayList();
        int c = 0;
        for(String str: words) {
            int s = temp.size();
            if (str.equals("prev")) {
                c++;
                if(c <= s) {
                    ans.add(temp.get(s - c));
                } else {
                    ans.add(-1);
                }
            } else {
                c = 0;
                temp.add(Integer.parseInt(str));
            }
        }
        return ans;
    }
}