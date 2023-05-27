package RecursivePractice;

public class PerfectNumber {
    public static int squareOfDigits(int number) {
        int digitSum = 0;
        while (number > 0) {
            int digit = number % 10;
            digitSum += digit * digit;
            number /= 10;
        }
        return digitSum;
    }

    public static boolean isPerfect(int number) {
        System.out.println("number before loop = " + number);
        while (true) {
            number = squareOfDigits(number);
            if (number == 1) {
                return true;
            } else if (number == 4) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Is perfect = " + isPerfect(86));
    }
}
