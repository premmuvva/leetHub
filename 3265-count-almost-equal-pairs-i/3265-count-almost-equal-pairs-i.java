class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length, ans = 0, dig, t1, t2, arr[] = new int[n];
        for (int i = 0; i< n; i++) {
            dig = nums[i];
            t2 = 0;
            while(dig != 0) {
                t1 = dig % 10;
                if ((t2 & (1 << t1)) == 0) {
                    t2 += 1 << t1;
                }
                dig /= 10;
            }
            arr[i] = t2;
        }
        String s1, s2;
        for (int i = 0; i< n; i++) {
            for (int j = i+1; j<n; j++) {
                if ((arr[i] & 1) == 0) {
                    arr[i] += 1;
                }
                if ((arr[j] & 1) == 0) {
                    arr[j] += 1;
                }
                if (arr[i] != arr[j]) continue;
                s1 = Integer.toString(nums[i]);
                s2 = Integer.toString(nums[j]);
                t1 = s1.length();
                t2 = s2.length();
                if (t1 > t2) {
                    s2 = "0".repeat(t1-t2) + s2;
                } else {
                    s1 = "0".repeat(t2-t1) + s1;
                }
                t1 = Math.max(t1, t2);
                t2 = 0;
                char[] ch = new char[2];
                for (int k = 0; k < t1; k++) {
                    if (s1.charAt(k) != s2.charAt(k)) {
                        if (t2 == 0) {
                            ch = new char[] {s1.charAt(k), s2.charAt(k)};
                        } else if (t2 == 1) {
                            if (ch[0] != s2.charAt(k) || ch[1] != s1.charAt(k)) {
                                break;
                            }
                        }
                        t2++;
                        if (t2 > 2) break;
                    }
                }
                
                if (t2 == 2 || t2 == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}