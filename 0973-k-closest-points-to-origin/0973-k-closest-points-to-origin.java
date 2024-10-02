class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int square = Integer.MAX_VALUE;
        Arrays.sort(points, (a, b) -> squ(a) - squ(b));
        return (int[][]) (Arrays.stream(points).limit(k).toArray(int[][]::new));
    }
    
    int squ(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}