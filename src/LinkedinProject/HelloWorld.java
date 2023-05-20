package LinkedinProject;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.logging.Logger;

public class HelloWorld {
    static final Logger logger = Logger.getLogger(String.valueOf(HelloWorld.class));

    public static void main(String[] args) {
        logger.info("Hello World");
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        if(arr.length!=0) logger.info("Max:="+findMax2(arr));
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

    public static Integer findMax2(int[] arr) throws NullPointerException, NoSuchElementException {
        int max = 0;
          if(arr.length==0) throw new NoSuchElementException("Array is empty");
          else max = Arrays.stream(arr).reduce(0, Integer::max);
        return max;
    }
}
