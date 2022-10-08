package MixProblems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonDuplicateCharInString {
    public static void main(String[] args) {
        String str = "abcdyhektabcd";
        System.out.println("============= FirstNonDuplicateCharInString: ============");
        System.out.println("str=" + str + ": " + firstNonDuplicateChar(str));
    }

    public static char firstNonDuplicateChar(String str) {
        char[] arr = str.toCharArray();
        //Map<Character, Integer> map = new HashMap<>();//  but order of insertion is not guaranteed
        Map<Character, Integer> map = new LinkedHashMap<>(); // LinkedHashMap maintains the order of insertion
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //print map
        Set<Character> keys = map.keySet();
        System.out.println("keys = " + keys);

        // print the first non-duplicate char
        char result = ' ';
//        for(int i=0; i<arr.length; i++) {
//            if(map.get(arr[i])==1) {
//                result = arr[i];
//                break;
//            }
//        }

        for(Character key : keys) {
            if(map.get(key)==1) {
                result = key;
                break;
            }
        }

        return result;
    }
}
