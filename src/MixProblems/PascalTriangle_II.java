package MixProblems;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_II {
    public static void main(String[] args) {
        System.out.println("getRow(3) = " + getRow(3));
        System.out.println("getRow2(3) = " + getRow2(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){
            row.add(0,1);
            for(int j=1; j<row.size()-1; j++){
                row.set(j, row.get(j)+row.get(j+1));
            }
        }
        return row;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++){
            for(int j=row.size()-1; j>=1; j--){
                row.set(j, row.get(j)+row.get(j-1));
            }
            row.add(1);
            result.add(new ArrayList<>(row));
        }
        return result.get(result.size()-1);
    }
}
