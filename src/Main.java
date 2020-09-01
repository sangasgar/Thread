public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    public static void main(String[] args) {

        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println(a);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis());
        System.out.println((System.currentTimeMillis() - a));




//        MyThread t1= new MyThread("t1");
//        MyThread t2= new MyThread("t2");


//        Thread t1 = new Thread(new MyRunnable("t1"));
//        Thread t2 = new Thread(new MyRunnable("t2"));

//        t1.start();
//        t2.start();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()  + " " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Counter c = new Counter();


        Thread t4 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                c.inc();
            }
        });
        Thread t5 = new Thread(()->{
            for (int i = 0; i < 1000000; i++) {
                c.dec();
            }
        });
        t4.start();
        t5.start();
        try {
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.getC());
        System.out.println("End");

    }
}

