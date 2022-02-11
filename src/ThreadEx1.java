import java.io.*;
import java.util.*;

public class ThreadEx1 {
    public static void main(String[] args) {
        Thread t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
        // 실행시 순서가 바뀌는데 이는 실행시마다 스케쥴링되는것이다르기때문
    }

}
class ThreadEx1_1 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(this.getName());
        }
    }
}

class ThreadEx1_2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}