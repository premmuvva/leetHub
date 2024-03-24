class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] split = text.split(" ");
        int ans = 0;
        boolean flag;
        for (String str: split) {
            flag = true;
            for (char ch: brokenLetters.toCharArray()) {
                flag = flag && check(str, ch);
                if(!flag) break;
            }
            if(flag) ans++;
        }
        return ans;
    }
    
    private boolean check(String str, char ch) {
        return str.lastIndexOf(ch) == -1;
    }
}