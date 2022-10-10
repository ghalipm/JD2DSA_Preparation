package MixProblems;

public class MathOps {

    public static int mathChecker(int input1, String operator, int input2){
        int result=0;
        switch (operator) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                result = input1 / input2;
                break;
            default:
                System.out.println("Invalid operator");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("============= MathOps: ============");
        System.out.println("mathChecker(2, '+', 3) = " + mathChecker(2, "+", 3));
        System.out.println("mathChecker(2, '-', 3) = " + mathChecker(2, "-", 3));
        System.out.println("mathChecker(2, '*', 3) = " + mathChecker(2, "*", 3));
        System.out.println("mathChecker(2, '/', 3) = " + mathChecker(2, "/", 3));
    }
}
