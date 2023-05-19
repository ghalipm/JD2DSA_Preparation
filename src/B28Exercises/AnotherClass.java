package B28Exercises;

public class AnotherClass {
    public static int product(int a, int b) {
        return a * b;
    }

    public AnotherClass(String genderX, int ageX, String nameX) {
       gender = genderX;
       age = ageX;
       name = nameX;
    }

    public AnotherClass(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "AnotherClass{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public AnotherClass() {
    }

    public static int difference(int a, int b) {
        return a - b;
    }

    public String gender="M";
    public int age=30;
    public String name="John";

}
