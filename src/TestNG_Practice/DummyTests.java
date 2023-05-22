package TestNG_Practice;

import org.testng.annotations.Test;

public class DummyTests {

    @Test(groups = {"smoke", "regression"})
    public void test1(){
        System.out.println("This is test 1");
    }

    @Test(groups = {"smoke"})
    public void test2(){
        System.out.println("This is test 2");
    }

    @Test(groups = {"regression"})
    public void test3(){
        System.out.println("This is test 3");
    }

    @Test(groups = {"regression"})
    public void test4(){
        System.out.println("This is test 4");
    }

    @Test(groups = {"regression"})
    public void test5(){
        System.out.println("This is test 5");
    }

    @Test(groups = {"smoke"})
    public void test6(){
        System.out.println("This is test 6");
    }
}
