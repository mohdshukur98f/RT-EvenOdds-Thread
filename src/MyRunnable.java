import java.util.Scanner;

public class MyRunnable implements Runnable {

     int x;
     int y;

    public static void main(String[] args) {
        MyRunnable myRunnable= new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
    }

    public void run(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Please input x: ");
        int x = scan.nextInt();

        System.out.print("Please input y: ");
        int y = scan.nextInt();

        OddNumber odd = new OddNumber();
        EvenNumber even = new EvenNumber();

        Thread t1 = new Thread(odd);
        Thread t2 = new Thread(even);

        t1.start();
        t2.start();
    }

    class OddNumber implements Runnable{

        @Override
        public void run() {
            for(int i = x; i<=y; i++){
                if(i % 2 == 1){
                    System.out.println(Thread.currentThread().getName()+ ": "+i);
                }
            }
        }
    }
    class EvenNumber implements Runnable{

        @Override
        public void run() {
            for(int i = x; i<=y; i++){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName()+ ": "+i);
                }
            }
        }
    }
}