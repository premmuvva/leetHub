/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 0, en = n, mid = 0;
        while(st < en) {
            mid = st + (en-st)/2;
            if (isBadVersion(mid)) en = mid;
            else st = mid+1;
        }
        return st;
    }
}