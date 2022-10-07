package RecursivePractice;

public class FibonacciSequence {

    private static long[] fibonacciArray ;

    public static void main(String[] args) {
        int n=55;
        long durationI;
        System.out.println("=============Improved Fibonacci Sequence: =======");
        {
            //starting time:
            long startTimeI = System.nanoTime();
            //initializing the array:
            fibonacciArray = new long[n + 1];
            System.out.println(n+"-th Fibonacci number="+fibonacci(n));
            //ending time:
            long endTimeI = System.nanoTime();
            durationI = endTimeI - startTimeI;
            System.out.println("Time elapsed: " + (endTimeI - startTimeI) + "ns");
        }

        System.out.println("=============Regular Fibonacci Sequence: =======");
        long startTimeR = System.nanoTime();
        System.out.println("fib(n) = " + fib(n));
        long endTimeR = System.nanoTime();
        System.out.println("Time elapsed for regular Fibonacci: " + (endTimeR - startTimeR) + "ns");

        System.out.println("speed ratio: fib/fibonacci = "+ (endTimeR - startTimeR)/(durationI));
    }

    private static long fib(int n) {
        if (n <= 1) {
            return n;
        }
         return fib(n-1) + fib(n-2);
        }


    private static long fibonacci(int n) {
        if(n<0){return -1;}

        if (n <= 1) {
            return n;
        }

        //if the value is calculated, return/do not calculate again:
        if(fibonacciArray[n]!=0){
            return fibonacciArray[n];
        }
        //calculate the value only, if it is not calculated:
        fibonacciArray[n]= fibonacci(n-1) + fibonacci(n-2);
        return fibonacciArray[n];
    }

}
