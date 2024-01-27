package mix_problems;

/**
 * @author ghalipm on 1/27/2024
 * @project JD2DSA_Preparation
 */

import java.util.Arrays;

/**
 * How to convert a positive int to an array of digits.
 * Input: 491 Output: [4, 9, 1] (as int Array
 */
public class ArrayOfDigits {
    public static void main(String[] args) {
        int num = 491;

        System.out.println("digitToArrayWithMod(num) = " + Arrays.toString(digitToArrayWithMod(num)));
        System.out.println("digitToArray(491) = " + Arrays.toString(digitToArray(num)));


    }

    public static int[] digitToArrayWithMod(int num){
        String numString = num + "";
        int n = numString.length();
        int[] digitArr = new int[n];

        int currentDigit = 0;
        while (num != 0) {
            // get each digit
            currentDigit = (num % 10); // 1
            num = num / 10; // 49
            digitArr[--n] = currentDigit; // start from the end of the array
        }
        return digitArr;

    }
       public static int[] digitToArray(int digit) {
        String stringDigit=digit+"";
        int len=stringDigit.length();
            int[] digitArr=new int[len];
            while (!stringDigit.isEmpty()){
                digitArr[--len]=Integer.parseInt(stringDigit.substring(len,len+1));
                stringDigit=stringDigit.substring(0,len);
            }
        return digitArr;

       }



    }

