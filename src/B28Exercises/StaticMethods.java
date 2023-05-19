package B28Exercises;

public class StaticMethods {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("======================");
        AnotherClass anotherClass = new AnotherClass();
        System.out.println("sum="+sum(2, 3));
        System.out.println("product="+anotherClass.product(2, 3));

        System.out.println("static method called through Class="+AnotherClass.difference(6, 4));
        System.out.println("calling static method through object="+anotherClass.difference(6, 4));

        //System.out.println("Gender="+AnotherClass.gender);
        System.out.println("Gender="+anotherClass.gender);

        AnotherClass newObject = new AnotherClass("F", 25, "Jane");
        System.out.println(newObject);


    }
public static int sum(int a, int b){
        return a+b;
    }

}
