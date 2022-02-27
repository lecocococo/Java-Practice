import java.util.concurrent.*;

// fork & join 프레임워크 이용
// fork & join 프레임워크를 이용한것이
// 더 느린 이유는 작업을 나누고 병합하는데 시간이 걸리기때문
public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L; long to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);

        System.out.println("Elasped Time(6core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis();
        for(long i = from;i<=to;i++){
            result += i;
        }
        System.out.println("Elasped Time(1core) : " + (System.currentTimeMillis() - start));
        System.out.printf("sum of %d ~ %d = %d%n", from, to, result);
    }

}

class SumTask extends RecursiveTask<Long>{
    long from, to;

    public SumTask(Long from, Long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long size = to - from +1;
        if(size<=5){
            return sum();
        }

        long mid = (from + to) /2;

        SumTask left = new SumTask(from, mid);
        SumTask right = new SumTask(mid + 1, to);

        left.fork();

        return right.compute() + left.join();
    }

    Long sum(){
        long tmp = 0L;
        for(long i =from;i<=to;i++){
            tmp += i;
        }
        return tmp;
    }
}
