import javax.swing.JOptionPane;

// 입력 받을때 까지 숫자 카운팅이 안됨(쓰레드가 한개이기떄문에)
public class ThreadEx6 {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 "+ input + " 입니다.");

        for(int i = 10;i>0;i--){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }
}
