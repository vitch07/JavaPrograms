package threads;

public class Main {
    public static void main(String[] args){ //Main thread
        Thread t1 = new MyThread("vishnu",500);
        Thread t2 = new MyThread("balaji",1000);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println(" INterupion occured");
        }

        System.out.println(Thread.activeCount());
    }
}
