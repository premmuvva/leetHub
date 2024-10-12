class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0 ;i <n-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;

    }
}