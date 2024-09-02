class Solution {
    public int daysBetweenDates(String date1, String date2) {
        String[] date1s = date1.split("-");
        String[] date2s = date2.split("-"); 
        int year1 = Integer.parseInt(date1s[0]);
        int year2 = Integer.parseInt(date2s[0]);
        int month1 = Integer.parseInt(date1s[1]);
        int month2 = Integer.parseInt(date2s[1]);
        int day1 = Integer.parseInt(date1s[2]);
        int day2 = Integer.parseInt(date2s[2]);
        // long ini = 0L, fin = 0L;
        int a1 = count(year2, month2, day2);
        int a2 = count(year1, month1, day1);
        // System.out.println(a1);
        // System.out.println(a2);
        // System.out.println(a1 - a2);
        return Math.abs(count(year2, month2, day2) - count(year1, month1, day1));
        
    }
    
    public int count(int year, int months, int day) {
        int month[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int leapMonth[] = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ms = 0;
        for (int i = 0; i<months-1; i++) {
            ms += month[i];
        }
        int ans = (year - 1971) * 365 + ms + day;
        for (int i = 1971; i<year; i++) {
            if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
                ans ++;
            }
        }
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) && months > 2) {
            ans ++;
        }
        return ans;
        // if (year % 4 == 0) {
        //     for(int i = 0; i < months - 1; i++) {
        //         ans += leapMonth[i];
        //     }
        // } else {
        //     for(int i = 0; i < months - 1; i++) {
        //         ans += month[i];
        //     }
        // }
        // ans += (365 * year);
        // ans += ((year - 1) / 4);
        // ans -= ((year - 1) / 100);
        // ans += ((year - 1) / 400);
        // ans += day;
        // // System.out.println(ans);
        // return ans;
    }
}