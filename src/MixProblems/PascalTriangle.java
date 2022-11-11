package MixProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        generate(5);
        //System.out.println("generate(5) = " + generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            for(int j=row.size()-1; j>=1; j--){
                row.set(j, row.get(j)+row.get(j-1));
            }
            row.add(1);
            System.out.println("row = " + row);
            result.add(new ArrayList<>(row));
        }
        return result;
    }


}
