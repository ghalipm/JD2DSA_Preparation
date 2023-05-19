package Generics;

public class StrAddition implements Addition<String> {

    public String addObjects(String obj1, String obj2){
        //return  obj1+obj2;
        return  obj1.concat(obj2);
    }
}

