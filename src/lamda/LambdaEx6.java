package lamda;

import java.util.*;
import java.util.function.*;

public class LambdaEx6 {
    public static void main(String[] args) {
        IntSupplier supplier = ()->(int)(Math.random()*100) + 1;
        IntConsumer consumer = i -> System.out.print(i+", ");
        IntPredicate p = i -> i%2==0;
        IntUnaryOperator op = i -> i/10*10;

        int[] arr =new int[10];

        makeRandomList(supplier, arr);
        System.out.println(Arrays.toString(arr));
        printEvenNum(p,consumer,arr);
        int[] newArr = doSomething(op, arr);
        System.out.println(Arrays.toString(newArr));

    }

    static <T> int[] doSomething(IntUnaryOperator op, int[] arr){
        int[] newArr = new int[arr.length];

        for(int i=0;i<newArr.length;i++){
            newArr[i] = op.applyAsInt(arr[i]);
        }

        return newArr;
    }

    static <T> void printEvenNum(IntPredicate p,IntConsumer c, int[] arr){
        System.out.print("[");

        for(int i: arr){
            if(p.test(i)){
                c.accept(i);
            }
        }

        System.out.println("]");
    }

    static <T> void makeRandomList(IntSupplier s, int[] arr){
        for(int i=0;i<10;i++){
           arr[i] = s.getAsInt();
        }
    }
}
