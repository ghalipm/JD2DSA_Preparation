package MixProblems;

public class ExampleStatic {
    public static void main(String[] args) {
        ExampleStatic obj1 = new ExampleStatic();
        System.out.println("obj1.doubler(3) = " + obj1.doubler(3));
        print();
        obj1.print(); // bad practice
    }

    public static void print() {
        System.out.println("print() method");
    }

    public int doubler(int n) {
        return 2*n;
    }
}
