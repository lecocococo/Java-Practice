package lamda;

// 람다식은 실제로 익명의 객체이다
// MyFunction인터페이스를 구현한 익명 객체를 람다식으로 대체 가능한이유는
// 람다식의 매개변수와 타입, 개수 그리고 반환값이 일치 하기 대문이다.
interface MyFunction{
    public abstract void run();
}

public class LambdaEx1 {
    static void execute(MyFunction f){
        f.run();
    }

    static MyFunction getMyFunction(){
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(()-> System.out.println("run()"));
    }
}
