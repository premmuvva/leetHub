class Solution {
    public String numberToWords(int num) {
        Map<Integer, String> hm = new LinkedHashMap(){{
            this.put(1000000000, "Billion ");
            this.put(1000000, "Million ");
            this.put(1000, "Thousand ");
            this.put(1, "");
        }};
        int key;
        String ans = "";
        for (Map.Entry<Integer, String> entry: hm.entrySet()) {
            key = entry.getKey();
            if (num / key != 0) {
                ans += processThree(num / key) + entry.getValue();
            }
            num %= key;
        }
        if (ans == "") {
            return "Zero";
        }
        return ans.strip();
    }
    
    private String processThree(int num) {
        int third = num / 100;
        String ans = "";
        if (third != 0) {
            ans = secondDigit(third) + "Hundred " + secondDigit(num % 100);
        } else {
            ans = secondDigit(num % 100);
        }
        return ans;
    }
    
    private String secondDigit(int num) {
        switch (num/10) {
            case 0: 
                switch (num) {
                    case 0:
                        return "";
                    case 1: 
                        return "One ";
                    case 2: 
                        return "Two ";
                    case 3: 
                        return "Three ";
                    case 4: 
                        return "Four ";
                    case 5: 
                        return "Five ";
                    case 6: 
                        return "Six ";
                    case 7: 
                        return "Seven ";
                    case 8: 
                        return "Eight ";
                    case 9: 
                        return "Nine ";
                }
            case 1: 
                switch (num) {
                    case 10: 
                        return "Ten ";
                    case 11: 
                        return "Eleven ";
                    case 12: 
                        return "Twelve ";
                    case 13: 
                        return "Thirteen ";
                    case 14: 
                        return "Fourteen ";
                    case 15: 
                        return "Fifteen ";
                    case 16: 
                        return "Sixteen ";
                    case 17: 
                        return "Seventeen ";
                    case 18: 
                        return "Eighteen ";
                    case 19: 
                        return "Nineteen ";
                }
            case 2: 
                return "Twenty " + secondDigit(num%10);
            case 3: 
                return "Thirty " + secondDigit(num%10);
            case 4: 
                return "Forty " + secondDigit(num%10);
            case 5: 
                return "Fifty " + secondDigit(num%10);
            case 6: 
                return "Sixty " + secondDigit(num%10);
            case 7: 
                return "Seventy " + secondDigit(num%10);
            case 8: 
                return "Eighty " + secondDigit(num%10);
            case 9: 
                return "Ninety " + secondDigit(num%10);
        }
        System.out.println(num);
        return "here";
        
    }
}