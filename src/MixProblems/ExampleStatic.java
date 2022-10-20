package MixProblems;

public class ExampleStatic {
    public static void main(String[] args) {
        ExampleStatic obj1 = new ExampleStatic();
        print();
        obj1.print();
        doubler(3);
        System.out.println("obj1.doubler(3) = " + obj1.doubler(3));
    }

    public static void print() {
        System.out.println("print() method");
    }

    public static int doubler(int n) {
        return 2*n;
    }
}
