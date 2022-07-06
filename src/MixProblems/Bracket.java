package MixProblems;

/**
 * Problem-3: Valid Parantheses
 * Write a function that takes a string of parentheses, and determines if the order
 * of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's invalid.
 * Examples
 * "()" => true
 * ")(()))" => false
 * "(" => false
 * "(())(((a23)())())" => true
 * Constraints
 * 0 <= input.length <= 100
 * Along with opening (() and closing ()) parenthesis, input may contain any
 * valid ASCII characters.
 * Furthermore, the input string may be empty and/or not contain any parentheses at all.
 * Do not treat other
 * forms of brackets as parentheses (e.g. [], {}, <>).
 * Link => https://www.codewars.com/kata/52774a314c2333f0a700068
 */
public class Bracket {
    public static void main(String[] args) {
        String bracket="";
        System.out.println("isBalanced{"+bracket+"} = " + isBalanced(bracket));
    }


public static boolean isBalanced(String str){

    int count=0;

    for (int i = 0; i < str.length(); i++) {
        if(str.charAt(i)== '(' ){
            count++;
        }else if(str.charAt(i)== ')'){
            count--;
            if(count<0) {
                break;
            }

        }

    }

    return count==0;
}


}
