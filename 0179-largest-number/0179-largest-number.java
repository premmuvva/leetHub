class Solution {
    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums)
            // .peek(System.out::println)
            .mapToObj(i -> String.valueOf(i))
            .sorted((b, a) -> compareTo(a, b))
            .collect(Collectors.joining());
            // .reduce(new StringBuilder(), (acc, str) -> acc.append(str.charAt(0)), (sb1, sb2) -> sb1.append(sb2))
            // .toString();
            // .map(StringBuilder::toString);        
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
}