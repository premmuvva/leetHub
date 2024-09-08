class Solution {
    public String convertDateToBinary(String date) {
        String[] spl = date.split("-");
        return Integer.toBinaryString(Integer.parseInt(spl[0])) + "-" + Integer.toBinaryString(Integer.parseInt(spl[1])) + "-" + Integer.toBinaryString(Integer.parseInt(spl[2]));
    }

}