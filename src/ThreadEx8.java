// setPriority(), getPriority()
// 쓰레드의 우선순위의 범위는 1~10
// Main메서드가 수행되는 쓰레드는 우선순위가 5
// 따라서 main에서 생선되는 쓰레드는 자동적으로 우선순위가 5가 된다.

// 실행결과를 보면 멀티코어에선 쓰레드의 우선순위에따른 차의가 없다.
// 그렇기 때문에 쓰레드에 우선순위를 부여하는 대신 작업에 우선순위를 두어
// PriorityQueue에 저장 해두고 우선순위가 높은 작업이 먼저 처리 되도록 하는것이 나을수 있다.
public class ThreadEx8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread8_1());
        Thread t2 = new Thread(new Thread8_2());

        t2.setPriority(7);

        System.out.println("t1의 우선순위 : " + t1.getPriority());
        System.out.println("t2의 우선순위 : " + t2.getPriority());

        t1.start();
        t2.start();
    }
}

class Thread8_1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<300;i++) {
            System.out.print("-");
            for (int j = 0; j < 1000000; j++) ;
        }
    }
}

class Thread8_2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<300;i++) {
            System.out.print("|");
            for (int j = 0; j < 1000000; j++) ;
        }
    }
}