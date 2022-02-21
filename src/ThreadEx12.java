//Thread 의 sleep()은 항상 현재 실행중인 쓰레드에 대해 작동하기 때문에
// 참조변수로 호출하지 말고 일시정지할 쓰레드에 가서
// Thread.sleep(1000) 이렇게 해야함
public class ThreadEx12 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new ThreadEx12_1());
        Thread th2 = new Thread(new ThreadEx12_2());

        th1.start();
        th2.start();
        
        try{
            th1.sleep(1000);
        }catch (InterruptedException e){
            
        }
        System.out.println("main 종료");
    }
    
}

class ThreadEx12_1 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<300;i++){
            System.out.print("-");
        }
        System.out.println(" th1 종료");
    }
}

class ThreadEx12_2 implements Runnable{

    @Override
    public void run() {
        for(int i=0; i<300;i++){
            System.out.print("ㅣ");
        }
        System.out.println(" th2 종료");
    }
}