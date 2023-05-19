package LinkedinProject;

import java.util.Arrays;

public class SwapWithoutThirdVariable<T> {
    T obj;

    public SwapWithoutThirdVariable(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        String str1="Hello", str2="World";

        // Using '+' operator
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        System.out.println("num1 = " + num1);     // Output: num1 = 10
        System.out.println("num2 = " + num2);     // Output: num2 = 5

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

        System.out.println("After swap="+Arrays.toString(swap(num1, num2)));
        System.out.println("After swap="+Arrays.toString(swap(str1, str2)));

    }

    public static Object[] swap(String str1, String str2) {
        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());
        str1 = str1.substring(str2.length());
        return new Object[]{str1, str2};
    }

    public static Object[] swap(int num1, int num2) {
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        return new Object[]{num1, num2};
    }



}
