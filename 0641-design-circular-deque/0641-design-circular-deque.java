class MyCircularDeque {
    
    int [] qu;
    int siz, st, en, cz;

    public MyCircularDeque(int k) {
        qu = new int[k];
        siz = k;
        st = 0;
        en = 0;
        cz = 0;
    }
    
    public boolean insertFront(int value) {
        if (siz == cz) return false;
        qu[mod(--st,siz)] = value;
        cz++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (siz == cz) return false;
        qu[mod(en++,siz)] = value;
        cz++;
        return true;
    }
    
    public boolean deleteFront() {
        if (cz == 0) return false;
        st++;
        cz--;
        return true;
    }
    
    public boolean deleteLast() {
        if (cz == 0) return false;
        en--;
        cz--;
        return true;
    }
    
    public int getFront() {
        if (cz == 0) return -1;
        return (qu[mod(st,siz)]);
    }
    
    public int getRear() {
        if (cz == 0) return -1;
        return (qu[mod(en-1,siz)]);
    }
    
    public boolean isEmpty() {
        return cz == 0;
    }
    
    public boolean isFull() {
        return cz == siz;
    }
    
    private int mod(int a, int b) {
        return ((a % b) + b) % b;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */