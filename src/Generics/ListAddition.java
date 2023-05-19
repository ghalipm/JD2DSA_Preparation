package Generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListAddition implements Addition<List<Integer>> {

    public List<Integer> addObjects(List<Integer> obj1, List<Integer> obj2){
        List<Integer> list = new LinkedList<>();
        list.addAll(obj1);
        list.addAll(obj2);
        return list;
    }
}

