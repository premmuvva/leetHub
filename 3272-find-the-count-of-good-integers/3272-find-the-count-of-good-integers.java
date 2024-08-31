class Solution {
    public long countGoodIntegers(int n, int k) {
        long val = 0L;
        long ans = 0;
        if (n == 1) {
            for (int i = 1; i< 10; i++) 
                if (i % k == 0) ans ++;
            return ans;
        }
        Set<Long> hs = new HashSet();
        for (int i = 1; i < 10; i++) {
            long temp = val + (i + powerN(10, n-1) * i);
            rec(n-2, k, temp, 1, hs);
        }

        for (long i: hs) {
            ans += perm(i, n);
        }
        return ans;
    }

    long perm(long a, int n) {
        long ans = factorial(n);
        int temp = (int)(a & 15);
        a = a >> 4;
        long fa = factorial(n-1) / (factorial(temp) * factorial(n - 1 - temp));
        fa *= (factorial(n - temp));
        ans = fa;
        for (int i = 1; i<10; i++) {
            temp = (int)(a & 15);
            a = a >> 4;
            ans /= factorial(temp);
        }
        return ans;
    }

    long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    long rec(int n, int k, long val, int mul, Set<Long> hs) {
        if (n == 0) {
            if (val % k == 0) {
                hs.add(countBits(val));
            }
            return val%k == 0L ? 1L : 0L;
        } else if (n == 1) {
            long ans = 0L;
            for (int i = 0; i < 10; i++) {
                long temp = val + powerN(10, mul) * (powerN(10, n-1) * i);
                if (temp % k == 0) {
                    hs.add(countBits(temp));
                }
                ans += (temp %k == 0L ? 1L : 0L);
            }
            return ans;
        }
        long ans = 0L;
        for (int i = 0; i < 10; i++) {
            long temp = val + powerN(10, mul) * (i + powerN(10, n-1) * i);
            ans += rec(n - 2, k, temp, mul + 1, hs);
        }
        return ans;
    }

    long countBits(long val) {
        int ar[] = new int[10];
        while (val > 0) {
            ar[(int)(val%10)]++;
            val /= 10;
        }
        long ans = 0L;
        for (int i = 9; i >= 0; i--) {
            ans = ans << 4;
            ans += ar[i];
        }
        return ans;
    }

    long powerN(int number, int power) {
        if(power == 0) return 1;
        int result = number;

        while(power > 1) {
            result*=number;
            power--;
        }

        return (long)result;
    }
}