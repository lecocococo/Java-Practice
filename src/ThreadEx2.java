// 호출스텍의 첫번째가 main이 아니라 run임을 볼 수 있다
public class ThreadEx2 {
    public static void main(String[] args) {
        Thread t1 = new ThreadEx2_1();

        t1.start();
    }


}
class ThreadEx2_1 extends Thread{

    @Override
    public void run() {
        throwException();
    }

    public void throwException(){
        try{
            throw new Exception();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
