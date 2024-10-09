class Solution {
    public long dividePlayers(int[] skill) {
        
        int n = skill.length;
        // if (n % 2 != 0) return -1;
        Arrays.sort(skill);
        int pro = skill[0] + skill[n-1];
        long ans = 0L,  t1, t2;
        int st = 0, en = n-1;
        while(st < en) {
            if(skill[st] + skill[en] != pro) return -1L;
            t1 = skill[st];
            t2 = skill[en];
            ans += t1*t2;
            st++;
            en--;
        }
        return ans;
    }
}