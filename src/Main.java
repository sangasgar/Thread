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
        double z =  (System.currentTimeMillis() - a);
        System.out.println(z);

// Действие в 2 потока
        float[] arr1 = new float[size];
        float[] a1 = new  float[10000000];
        float[] a2 = new  float[10000000];
        Object mon = new Object();
        long t = System.currentTimeMillis();
        System.out.println((t));
        Thread t10 = new Thread(() -> {

            synchronized (mon) {
                System.arraycopy(arr1, 0, a1, 0, h);
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = 1;
                }
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr1, 0, h);
            }

        });
        Thread t15 = new Thread(() -> {
            synchronized (mon) {
                System.arraycopy(arr1, h, a2, 0, h);
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = 1;
                }
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a2, 0, arr1, h, h);
            }
        });

        System.out.println((System.currentTimeMillis()));
        double e = System.currentTimeMillis() - t;
        System.out.println(e);
        System.out.println("Вывод в 2 потока получается быстрее в " + (int) (z / e) + " раз.");
//        MyThread t1= new MyThread("t1");
//        MyThread t2= new MyThread("t2");


//        Thread t1 = new Thread(new MyRunnable("t1"));
//        Thread t2 = new Thread(new MyRunnable("t2"));

//        t1.start();
//        t2.start();

    }
}

