

public class DoSomting {


    @BeforeSuite
    public  void beforeStart () {
        System.out.println(1);
    }

//    @BeforeSuite
//    public  void beforeStart2 () {
//        System.out.println(1);
//    }

    @Test(priotity = 3)
    public void doTest () {
        System.out.println(2);
    }

    @Test(priotity = 8)
    public void doTest2 () {
        System.out.println(2);
    }

    @AfterSuite
    public  void  afterStart ()  {
        System.out.println(3);
    }
//    @AfterSuite
//    public  void  afterStart2 ()  {
//        System.out.println(3);
//    }


}
