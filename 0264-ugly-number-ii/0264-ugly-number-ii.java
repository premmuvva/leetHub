class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> pq = new TreeSet();
        pq.add(1L);
        long i = 0, num = 0;
        while (n > 0) {
            num = pq.pollFirst();
            pq.add(num * 2);
            pq.add(num * 3);
            pq.add(num * 5);
            n--;
        }
        return (int) num;
    }
}