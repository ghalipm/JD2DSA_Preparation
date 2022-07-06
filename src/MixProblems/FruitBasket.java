package MixProblems;

public class FruitBasket {

    public static void main(String[] args) {
        int[] arr={1,2,2,2,1,1,3,3,2,1};
        System.out.println("Max number of fruits in the basket = " + totalFruit2(arr));
    }

    public static int totalFruit2(int[] arr) {

        int last_fruit = -1;
        int second_last_fruit = -1;
        int last_fruit_count = 0;
        int max = 0;
        int currentMax=0;
        
        for (int fruit : arr) {

            if(fruit==last_fruit || fruit==second_last_fruit){
                currentMax++;
            }else{
                currentMax=last_fruit_count+1;
            }

            if(fruit==last_fruit){ /////
                last_fruit_count++;
            }else{
                last_fruit_count=1;
                second_last_fruit=last_fruit;
                last_fruit=fruit;
            }

            max=Math.max(max,currentMax);

        }

        return max;
    }

    public static int totalFruit3(int[] arr) {

        int last_fruit = 0;
        int second_last_fruit = 0;
        int last_fruit_count = 0;
        int max = 0;
        int current_max=0;

        for (int fruit : arr) {

            if(fruit==last_fruit || fruit==second_last_fruit){
                current_max++;
            }else{
                current_max=last_fruit_count+1;
            }

            if(fruit==last_fruit){ /////
                last_fruit_count++;
            }else{
                last_fruit_count=1;
                second_last_fruit=last_fruit;
                last_fruit=fruit;
            }

            max=Math.max(max,current_max);

        }

        return max;
    }
}
