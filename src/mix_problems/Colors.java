package mix_problems;

import java.util.HashMap;
import java.util.List;

/**
 * @author ghalipm on 12/24/2023
 * @project JD2DSA_Preparation
 */
public class Colors {
    static HashMap<String,String> colors = new HashMap<>();
static {
    // Declaring the color
    // Custom declaration
        colors.put("red","\u001B[31m"); //
        colors.put("green","\u001B[32m");
        colors.put("blue","\u001B[34m");
        colors.put("black","\u001B[30m");
        colors.put("yellow","\u001B[33m");
        colors.put("orange","\u001B[38m");
        colors.put("purple","\u001B[35m");
        //color grey:
        colors.put("grey","\u001B[37m");

    }


    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";



    public String setColor2Object(String color, String message) {
        return colors.get(color.toLowerCase())+ message+ANSI_RESET;
    }

// T: Integer, Double, String
// once colorized, object t is lost as object,
// it is converted to string: colorValue is string.
    // String concatenated with String , it is string.
    static <T> String genericColorizer(T t, String color) {
        return colors.get(color.toLowerCase()) + t + ANSI_RESET;
    }


    public static <T> String listWithColor(List<T> list, String color) {
        return colors.get(color.toLowerCase())+list+ANSI_RESET;
    }

}
