import javax.swing.JOptionPane;
// 여기서는 interrupt()가 제대로 작동 안했는데 그이유는 Thread.sleep(1000)에서
// InterruptedException이 발생했기 때문이다.
// sleep()에 의해서 쓰레드가 잠시 멈춰있을때, interrupt()를 호출하면
// InterruptedException이 발생하고 쓰레드의 interrupted상태는 false로 자동 초기화된다.

public class ThreadEx14 {
    public static void main(String[] args) {
        Thread th1 = new Thread14();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하시오");
        System.out.println("입력하신 값은 "+ input + " 입니다.");
        th1.interrupt();
        System.out.println("isInterrupted(): " + th1.isInterrupted());
    }
}

class Thread14 extends Thread{

    public void run() {
        int i = 10;

//        while(i!=0 && !isInterrupted()){
//            System.out.println(i--);
//            // for(long x =0;x<2500000000L;x++);
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//
//            }
//        }

        // 해결책
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            // for(long x =0;x<2500000000L;x++);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                interrupt(); //다시 interrupted의 상태를 true로 바꿔준다.
            }
        }
        System.out.println("카운트가 종료 되었습니다.");
    }
}
