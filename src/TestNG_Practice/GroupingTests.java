package TestNG_Practice;

import org.testng.annotations.Test;

public class GroupingTests {

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

    @Test(groups = {"regression"})
    public void test6(){
        System.out.println("This is test 6");
    }

    @Test(groups = {"regression"})
    public void test7(){
        System.out.println("This is test 7");
    }

    @Test(groups = {"regression"})
    public void test8(){
        System.out.println("This is test 8");
    }

    @Test(priority = 2,groups = {"smoke"})
    public void test9(){
        System.out.println("This is test 9");
    }

    @Test(priority = 1, groups = {"regression"} )
    public void test10(){
        System.out.println("This is test 10");
    }
}
