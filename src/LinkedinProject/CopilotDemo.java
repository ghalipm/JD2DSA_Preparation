package LinkedinProject;

public class CopilotDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println("findMax(arr) = " + findMax(arr));
        double[] arr2={1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.10};
        System.out.println("findMax(arr2) = " + findMax(arr2));
    }

    //find max integer in array
    public static int findMax(int[] arr){
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    //find max double in array
    public static double findMax(double[] arr){
        double max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }


}
