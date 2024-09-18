class Solution {
    public String largestNumber(int[] nums) {
        String ans = Arrays.stream(nums)
            // .peek(System.out::println)
            .mapToObj(i -> String.valueOf(i))
            .sorted((b, a) -> compareTo(a, b))
            .reduce("", String::concat);
        
            // .toArray(String[]::new);
        
            // .peek(System.out::println)
            // 
            // .peek(System.out::println)
            // ;
            // .toArray();
        // Arrays.sort(arr, new Comparator<Integer>() {
        //     public int compare(Integer a, Integer b) {
        //         return String.valueOf(a).compareTo(String.valueOf(b));
        //     }
        // });
        // System.out.println(Arrays.toString(ans));
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