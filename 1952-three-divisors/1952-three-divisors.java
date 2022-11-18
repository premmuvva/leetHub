class Solution {
    public boolean isThree(int n) {
        if (n < 4) return false;
        int sqr = (int) Math.sqrt(n);
        if (sqr * sqr != n) return false;
        for (int i = 2; i*i <= sqr; i++)
            if (n % i == 0) 
                return false;
        return true;
    }
}