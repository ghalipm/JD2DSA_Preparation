package Generics;

import java.util.List;

public class Applications {
    public static void main(String[] args) {
        //addition of two Strings
        Addition<String> strAddition = new StrAddition();
        System.out.println("strAddition = " + strAddition.addObjects("Hello ", "World"));

        Addition<Integer> intAddition = new IntAddition();
        System.out.println("intAddition = " + intAddition.addObjects(5, 10));

       Addition<Double> doubleAddition = new DoubleAddition();
        System.out.println("doubleAddition = " + doubleAddition.addObjects(5.5, 10.5));

        Addition<List<Integer>> intListAddition = new ListAddition();
        System.out.println("intListAddition = " + intListAddition.addObjects(List.of(1,2,3), List.of(4,5,6)));

    }
}
