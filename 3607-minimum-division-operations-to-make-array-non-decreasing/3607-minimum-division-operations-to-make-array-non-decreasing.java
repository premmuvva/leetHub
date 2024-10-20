class Solution {
    int maxin = 1000001; 
    int divisors[];
    public int minOperations(int[] nums) {
        
        int ans = 0, n = nums.length, max = 0;
        for (int i = 0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }
        maxin = max;
        divisors = new int[maxin+ 1];
        Calc_Max_Div();
        // System.out.println(Arrays.toString(Arrays.copyOfRange(divisors, 24, 26)));
        for (int ii = 0; ii< n-1; ii++) {
            if (nums[ii] > nums[ii+1]) {
                int i = ii;
                while(i >= 0 && nums[i] > nums[i+1]) {
                    while(nums[i] > nums[i+1]) {
                        int div = divisors[nums[i]];

                        
                        if (div == 0) {
                            div = divisor(nums[i]);
                        }
                        // System.out.println(nums[i]);
                        // System.out.println(div);
                        if (div != nums[i]) {
                            nums[i] /= div;
                        } else {
                            return -1;
                        }
                    }
                    ans++;
                    i--;
                }
            }
        }
        return ans;
    }

    int divisor(int number)
    {
        int i;
        for (i = 2; i*i <= number; i++) {
            if (number % i == 0)
            {
                divisors[number] = number/i;
                return number/i;
            }
        }
        divisors[number] = number;
        return 1;
    }

    void Calc_Max_Div() 
    { 
     
        // Visited array to keep 
        // track of prime numbers 
        int vis[] = new int[maxin + 1];
         
        for(int i = 0;i <maxin+1 ; i++)
            vis[i] = 1;
 
        // 0 and 1 are not prime numbers 
        vis[0] = vis[1] = 0; 
     
        // Initialising divisors[i] = i 
        for (int i = 1; i < maxin; i++) 
            divisors[i] = i; 
     
        // For all the numbers divisible by 2 
        // the maximum divisor will be number / 2 
        for (int i = 4; i <= maxin; i += 2) { 
            vis[i] = 0; 
            divisors[i] = i / 2; 
        } 
        for (int i = 3; i <= maxin; i += 2) { 
     
            // If divisors[i] is not equal to i then 
            // this means that divisors[i] contains 
            // minimum prime divisor for the number 
            if (divisors[i] != i && divisors[i] != 0) { 
     
                // Update the answer to 
                // i / smallest_prime_divisor[i] 
                divisors[i] = i / divisors[i]; 
            } 
     
            // Condition if i is a prime number 
            if (vis[i] == 1) 
            { 
                for (long j = ((long)i) * i; j < maxin; j += i)
                { 
                    int jj = (int) j;
                    vis[jj] = 0; 
     
                    // If divisors[j] is equal to j then 
                    // this means that i is the first prime 
                    // divisor for j so we update divi[j] = i 
                    if (divisors[jj] == jj) 
                        divisors[jj] = i; 
                } 
            } 
        } 
    } 
}