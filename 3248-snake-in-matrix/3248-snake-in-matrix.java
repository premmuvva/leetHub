class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String str: commands) {
            if (str.equals("UP")) {
                x -= 1;
            } else if (str.equals("DOWN")) {
                x += 1;
            } else if (str.equals("LEFT")) {
                y -= 1;
            } else if (str.equals("RIGHT")) {
                y += 1;
            }
        }
        return n * x + y;
    }
}