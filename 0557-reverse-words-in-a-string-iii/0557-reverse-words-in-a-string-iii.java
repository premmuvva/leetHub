class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String str: arr)
            ans.append(new StringBuilder(str).reverse() + " ");
        return ans.toString().substring(0, ans.length() - 1);
    }
}