class Solution {
    public String convertToTitle(int columnNumber) {
        if ((columnNumber - 1)/26 == 0) {
            return String. valueOf((char) ((int)'A' + (columnNumber - 1) % 26 ));
        }
        return convertToTitle((columnNumber - 1)/26) + String. valueOf((char) ((int)'A' + (columnNumber - 1) % 26));
    }
}