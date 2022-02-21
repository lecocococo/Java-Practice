import javax.swing.JOptionPane;

public class ThreadEx13 {
    public static void main(String[] args) {
        Thread th1 = new Thread13();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하시오");
        System.out.println("입력하신 값은 "+ input + " 입니다.");
        th1.interrupt();
        System.out.println("isInterrupted(): " + th1.isInterrupted());
    }
}

class Thread13 extends Thread{

    public void run() {
        int i = 10;

        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            for(long x =0;x<2500000000L;x++);
        }
        System.out.println("카운트가 종료 되었습니다.");
    }
}
