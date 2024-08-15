class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fc = 0, tc = 0;
        for (int i : bills) {
            if (i == 5) fc++;
            else if (i == 10) {
                if (fc > 0) {
                    fc--;
                    tc++;
                } else return false;
            } else if (i == 20) {
                if (tc > 0 && fc > 0) {
                    fc--;
                    tc--;
                } else if (fc > 2) fc -= 3; 
                else return false;
            }
        }
        return true;
    }
}