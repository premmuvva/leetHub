class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() {
        tm = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer fkey = tm.floorKey(start);
        Integer ckey = tm.ceilingKey(start);
        if ((fkey == null || tm.get(fkey) <= start) && (ckey == null || ckey >= end)) {
            tm.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */