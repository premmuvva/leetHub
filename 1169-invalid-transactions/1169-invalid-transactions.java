class Solution {
    class Transaction {
        public String name, city, inp;
        public int time, amount;
        
        public Transaction(String val) {
            String[] strs = val.split(",");
            inp = val;
            name = strs[0];
            time = Integer.parseInt(strs[1]);
            amount = Integer.parseInt(strs[2]);
            city = strs[3];
        }
        
        public String toString() {
            return "name: " + name + " city: " + city + " time: " + time + " amount: " + amount + " ......... ";
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        List<String> names = new ArrayList();
        List<String> ans = new ArrayList();
        Map<String, List<Transaction>> hm = new HashMap();
        int n = transactions.length;
        for (int i = 0; i < n; i++) {
            Transaction tr = new Transaction(transactions[i]);
            hm.computeIfAbsent(tr.name, k -> new ArrayList()).add(tr);
        }
        // System.out.println(hm);
        for (Map.Entry<String, List<Transaction>> en: hm.entrySet()) {
            List<Transaction> trns = en.getValue();
            int asi = trns.size();
            // System.out.println(en);
            for (int i = 0; i < asi; i++) {
                if (!isValid(trns.get(i), trns)) {
                    ans.add(trns.get(i).inp);
                }
            }
        }
        
        return ans;
    }
    public boolean isValid(Transaction t, List<Transaction> list){
        if(t.amount > 1000){
			return false;
		}
        for(Transaction ta : list){
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)){
				return false;
			}
        }
        return true;
    }
}