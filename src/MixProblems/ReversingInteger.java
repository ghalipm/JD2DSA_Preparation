package MixProblems;

public class ReversingInteger {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("============= ReversingInteger: ============");
        System.out.println("n=" + n + ": " + reverse(n));
    }

    public static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }

    }

