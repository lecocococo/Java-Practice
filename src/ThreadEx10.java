// 데몬 쓰레드(daemon thread) 관련

// 3초마다 autoSave 확인하여 true이면 autoSave()를 호출하는 일을 무한 반복하는
// 데몬 쓰레드 생성
public class ThreadEx10 implements Runnable {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadEx10());
        t1.setDaemon(true);
        t1.start();

        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);

            if(i==5){
                autoSave = true;
            }

        }

        System.out.println("프로그램 종료");
    }


    public void run() {
        while (true){
            try {
             Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(autoSave){
                autoSave();
            }
        }
    }

    public void autoSave(){
        System.out.println("작업파일이 저장됨");
    }
}


