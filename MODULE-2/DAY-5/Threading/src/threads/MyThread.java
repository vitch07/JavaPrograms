package threads;

public class MyThread extends Thread {
    int delay;
    public MyThread(String name,int delay){
        super(name);
        this.delay = delay;
    }

    public void run(){
        for(int i = 1; i <= 25 ; i ++){
        System.out.println(i + this.getName());
        try{
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }}
}
