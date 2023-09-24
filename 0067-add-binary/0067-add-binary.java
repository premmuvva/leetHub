class Solution {
    public String addBinary(String a, String b) {
        int al = a.length(), bl = b.length(), min;
        if (al < bl) {
            a = new String(new char[bl-al]).replace('\0', '0') + a;
            // System.out.println(a);
            al = bl;
        } else {
            b = new String(new char[al-bl]).replace('\0', '0') + b;
            // System.out.println(b);
            bl = al;
        }
        String s = "";
        int c = 0, aa, bb;
        for (int i = al - 1; i>=0; i--) {
            aa = (a.charAt(i) - '0');
            bb = (b.charAt(i) - '0');
            
            // System.out.printf("%d %d %d",aa, bb , c);
            s = (char)((aa ^ bb ^ c) + '0') + s;
            c =  ((aa ^ bb) & c) | (aa & bb);
            // System.out.printf(" %d \n", c);
        }
        if (c == 1) s = '1' + s;
        return s;
    }
}