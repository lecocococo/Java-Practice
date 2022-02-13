import javax.swing.JOptionPane;

// 입력을 하지 않아도  숫자 카운팅이 됨(쓰레드가 두개이기떄문에)
public class ThreadEx7 {

    public static void main(String[] args) {
        Thread t1 = new Thread7_1();
        t1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 "+ input + " 입니다.");

    }

}

class Thread7_1 extends Thread{
    public void run(){
        for(int i = 10;i>0;i--){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}