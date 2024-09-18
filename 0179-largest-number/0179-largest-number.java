class Solution {
    public String largestNumber(int[] nums) {
        // String ans = Arrays.stream(nums)
        //     .mapToObj(i -> String.valueOf(i))
        //     .sorted((b, a) -> compareTo(a, b))
        //     .collect(Collectors.joining());
            // .reduce(new StringBuilder(), (acc, str) -> acc.append(str.charAt(0)), (sb1, sb2) -> sb1.append(sb2))
            // .toString();
            // .map(StringBuilder::toString);        
        String ans = Arrays.stream(nums)
            .mapToObj(i -> Integer.valueOf(i))
            .sorted((b, a) -> compareTo(a, b))
            .map(i -> String.valueOf(i))
            // .peek(System.out::println)
            // .collect(Collectors.joining());
            .reduce("", String::concat);
        return ans.charAt(0) == '0' ? "0": ans;
    }
    
    int compareTo(String aa, String bb) {
        int na = aa.length(), nb = bb.length();
        int n = 2 * Math.max(na, nb), st = 0;
        // System.out.println(aa);
        while(st < n) {
            if (aa.charAt(st%na) > bb.charAt(st%nb)) {
                return 1;
            } else if (aa.charAt(st%na) < bb.charAt(st%nb)) {
                return -1;
            } else {
                st++;
            }
        }
        return 1;
    }
    
    int compareTo(int a, int b) {
        long ta = a, tb = b;
        int ac = 1, bc = 1;
        while(ta > 0) {
            ta/=10;
            ac*=10;
        }
        while(tb > 0) {
            tb/=10;
            bc*=10;
        }
        // System.out.printf("%d %d %d %d\n", a, b, ac, bc);
        ta = (long)a * bc + b;
        tb = (long)b * ac + a;
        return ta == tb ? (a > b ? 1 : -1) : (ta > tb ? 1 : -1);
    }
}