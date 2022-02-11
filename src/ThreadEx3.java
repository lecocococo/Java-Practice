// 호출스텍의 첫번째가 main이 된다. (run()을 호출 했기 때문에)
public class ThreadEx3 {
    public static void main(String[] args) {
        Thread t1 = new ThreadEx2_1();

        t1.run();
    }


}
class ThreadEx3_1 extends Thread{

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
