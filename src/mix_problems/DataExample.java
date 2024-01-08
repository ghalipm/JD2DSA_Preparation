package mix_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ghalipm on 12/22/2023
 * @project JD2DSA_Preparation
 */


public class DataExample {

//    public static void main(String[] args) {
//        System.out.println("list = " + list);
//        System.out.println("Sorted list = " + Colors.listWithColor(sortedList,"blue"));
//        System.out.println("list.size() = " + list.size());
//
//        System.out.println("mean = " + Colors.genericColorizer(mean, "green"));
//        System.out.println("median = " + Colors.genericColorizer(median, "yellow"));
//        System.out.println("range = " + range);
//
//        System.out.println("quartile1 = " + Colors.genericColorizer(quartile1, "blue"));
//        System.out.println("quartile2 = " + Colors.genericColorizer(quartile2, "green"));
//        System.out.println("quartile3 = " + Colors.genericColorizer(quartile3, "blue"));
//
//        System.out.println("interQuartileRange = " + interQuartileRange);
//        System.out.println("lowerBound = " + Colors.genericColorizer(lowerFence, "orange"));
//        System.out.println("upperBound = " + Colors.genericColorizer(upperFence, "orange"));
//
//        System.out.println("lowerWhisker = " + Colors.genericColorizer(lowerWhisker, "blue"));
//        System.out.println("upperWhisker = " + Colors.genericColorizer(upperWhisker, "blue"));
//        System.out.println("outliers  = " + Colors.genericColorizer(outliers, "red"));
//
//        System.out.println("outlierPercentage = " +  outlierPercentage );
//        System.out.println("whiskerValues = " + whiskerValues);
//        System.out.println("boxed values = " + boxedValues);
//
//        System.out.println(".generalizedDisplay(2) = " + DataExample.generalizedDisplay(2, "green"));
//        System.out.println(".generalizedDisplay(2.0) = " + DataExample.generalizedDisplay(2.0, "blue"));
//        System.out.println(".generalizedDisplay(Hello) = " + DataExample.generalizedDisplay("Hello", "red"));
//
//        System.out.println("numOfRightOutliers = " + numOfRightOutliers);
//        System.out.println("numOfLeftOutliers = " + numOfLeftOutliers);
//        System.out.println(".outliers.get(numOfRightOutliers - 1) = " + DataExample.outliers.get(numOfTotalOutliers - 1));
//    }

    static Integer[] arr1 = {-18, 2, 10, 14, 16, 21, 25, 25, 29, 31, 35, 72};
    static Integer[] arr2 = {2, 10, 14, 16, 21, 25, 25, 29, 31, 35, 72};
    static Integer[] arr3 = {14, 16, 21, 25, 2, 10, 25, 29, 31, 35, -19};
    static Integer[] arr4 = {14, 16, 21, 25, 2, 10, 25, 29, 31, 35};
    static Integer[] arr5 = {2, 10, 14, 16, 21, 25, 25, -25, -29, 29, 31, 35,72, 76};
    static Integer[] arr6 = {2, 10, 14, 16, 21, 25, 25, 29, 31, 35,72, 76};
    static Integer[] arr7 = {2, 10, 14, 16, 21, 25, 25, 29, 31, 35, 71, 190};
    static Integer[] arr8 = {2, 10, 14, 16, 21, 25, 25, 29, 31, 35, 71, 200};

    static Integer[] arr9 = {
            105, 221, 183, 186, 121, 181, 180, 143,
            97, 154, 153, 174, 120, 168, 167, 141,
            245, 228, 174, 199, 181, 158, 176, 110,
            163, 131, 154, 115, 160, 208, 158, 133,
            207, 180,190, 193, 194, 133, 156, 123,
            134, 178, 76, 167, 184, 135, 229, 146,
            218, 157, 101, 171, 165, 172, 158, 169,
            199, 151, 142, 163, 145, 171, 148, 158,
            160, 175, 149, 87, 160, 237, 150, 135,
            196, 201, 200, 176, 150, 170, 118, 149
    };// working for this case also:


    //static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
    static ArrayList<Integer> list = new ArrayList<>(List.of(arr7));
    //sort the list in ascending order
    static ArrayList<Integer> sortedList;

    static {
        sortedList = list.stream().sorted(Comparator.comparingInt(a -> a)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    static double mean=list.stream().mapToDouble(a->a).average().getAsDouble();
    static double median=(list.size()%2==1)?list.get(list.size()/2):
            ((double) (list.get(list.size()/2 - 1) + list.get(list.size()/2)) /2);
    static double max=list.stream().mapToInt(a->a).max().getAsInt();
    static double min=list.stream().mapToInt(a->a).min().getAsInt();

    public static int maximum(List<Integer> list) {
        return list.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
    }

    static double range=max-min;
    static double quartileFinder(List<Integer> list){
        return (list.size()%2==1)?list.get(list.size()/2):
                 ((double) (list.get(list.size()/2 - 1) + list.get(list.size()/2)) /2);
    }
    static double quartile1=quartileFinder(sortedList.subList(0,sortedList.size()/2));
    static double quartile2=quartileFinder(sortedList);
    static double quartile3=(sortedList.size()%2==1)?quartileFinder(sortedList.subList(sortedList.size()/2+1,sortedList.size()))
            :quartileFinder(sortedList.subList(sortedList.size()/2,sortedList.size()));
    static double interQuartileRange=quartile3-quartile1;
    static double lowerFence=quartile1-1.5*interQuartileRange;//lowerBound
    static double upperFence=quartile3+1.5*interQuartileRange;//upperBound
    static List<Integer> outliers=list.stream().filter(a->a<lowerFence||a>upperFence).collect(Collectors.toList()).stream().sorted().collect(Collectors.toList());
    static double outlierPercentage= 100*(double) outliers.size()/list.size();

    static List<Integer> whiskerValues= sortedList.stream().filter(a->!(outliers.contains(a))).collect(Collectors.toList());
    static Integer lowerWhisker=whiskerValues.get(0);
    static Integer upperWhisker=whiskerValues.get(whiskerValues.size()-1);

    static List<Integer> boxedValues= sortedList.stream().filter(a->a>=quartile1 && a<=quartile3).collect(Collectors.toList());

    static int numOfTotalOutliers=outliers.size();
    static int numOfRightOutliers = (DataExample.outliers.stream().reduce(0, (subtotal, element) -> subtotal + (element > DataExample.upperWhisker ? 1 : 0)));
    static int numOfLeftOutliers = (DataExample.outliers.stream().reduce(0, (subtotal, element) -> subtotal + (element <DataExample.lowerWhisker ? 1 : 0)));


    /**
     * generalizedDisplay method to display any type of data:
     * Integer, Double or String and desired color as input; String output.
     * @param t
     * @param color
     * @return
     * @param <T>
     */

    // T: Integer. Double, String
    static <T> String generalizedDisplay(T t, String color)
    {
        return  " " + Colors.genericColorizer(t, color);
    }


}
