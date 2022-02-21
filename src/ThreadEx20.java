
// th1.join(100)을 이용해 메인쓰레드가 th1의 작업을 기다릴 수있도록함
public class ThreadEx20 {
    public static void main(String[] args) {
        Thread20 th1 = new Thread20();
        th1.setDaemon(true);
        th1.start();

        int requiredMemory =0;

        for(int i=0;i<20;i++){
            requiredMemory =(int)(Math.random() * 10) * 20;
            if(th1.freeMemory() < requiredMemory ||
                    th1.freeMemory() < th1.totalMemory() * 0.4){
                th1.interrupt();
                try{
                    th1.join(100);
                } catch (InterruptedException e){

                }
            }

            th1.usedMemory += requiredMemory;
            System.out.println("usedMemory:"+ th1.usedMemory);
        }
    }
}

class Thread20 extends Thread{
    final static int MAX_Memory =1000;
    int usedMemory = 0;

    public void run(){
        while(true){
            try {
                Thread.sleep(1000*10);
            }catch (InterruptedException e){
                System.out.println("awaken by interrupt()");
            }
            gc();
            System.out.println("Garbage Collected. Free Meemory : " + freeMemory());

        }
    }

    public void gc(){
        usedMemory -= 300;
        if(usedMemory<0){
            usedMemory = 0;
        }
    }
    public int totalMemory(){
        return  MAX_Memory;
    }
    public int freeMemory(){
        return MAX_Memory - usedMemory;
    }
}
