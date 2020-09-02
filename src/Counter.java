public class Counter {
    private int c;
    private Object mon;

    public Counter() {
        this.c = 0;
        mon = new Object();
    }

    public int getC() {

        return c;
    }
    public void inc () {
        synchronized (mon) {
            c++;
        }

    }
    public  void dec () {
        synchronized (mon) {
            c--;
        }
    }
}
