package LinkedinProject;

import java.util.logging.Logger;

public class HelloWorld {
    static final Logger logger = Logger.getLogger(String.valueOf(HelloWorld.class));

    public static void main(String[] args) {
        logger.info("Hello World"); //better than System.out.println("Hello World");

        int[] arr={1,2,3,4,5,6,7,8,9,10};
        logger.info("findMax(arr) = " + findMax(arr));
    }

    //find maximum integer in array
    public static int findMax(int[] arr){
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
}
