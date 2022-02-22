
// 쓰레드의 동기화관련
// synchronized 를 적지 않으면 balance에서 음수가 나온다.
// synchronized를 통해 임게영역 설정해주고 락을 이용하여
// 한번에 한 쓰래드만 접근이 가능하도록 해줌
public class ThreadEx21 {

    public static void main(String[] args) {
        Runnable r = new Thread21();

        new Thread(r).start();
        new Thread(r).start();
    }
}

class Account{
    private int balance = 1000;

    public int getBalance(){
        return balance;
    }

    public synchronized void withdraw(int money){
        if (balance>=money){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
            balance -= money;
        }
    }
}

class Thread21 implements Runnable{
    Account acc =new Account();

    @Override
    public void run() {
        while(acc.getBalance()>0){
            int money = (int) (Math.random()*3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance: " + acc.getBalance());
        }
    }
}