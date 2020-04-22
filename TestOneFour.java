
//*********************************
//testing class   for   task  2
//*********************************


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.*;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


@RunWith(Parameterized.class)
 public class TestOneFour {
    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 2, 3}},
                {true, new int[]{1, 1, 4, 4}},
                {true, new int[]{1, 1, 1}},
                {true, new int[]{4, 4, 4}},
                {true, new int[]{2, 3, 4}},
                {true, new int[]{1, 2, 4}},
        });
    }


    private boolean onlyOneFour;
    private int[] arrs;

    public TestOneFour(boolean onlyOneFour, int[] arrs) {
        this.onlyOneFour = onlyOneFour;
        this.arrs = arrs;
    }

    private NewMatrix newMatrix;

//    Handler handler;
//
//    {
//        try {
//            handler = new FileHandler("log.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private static final Logger LOGGER = Logger.getLogger(TestNewMatrix.class.getName());
    //   LOGGER.setLevel(Level.ALL);
//    LOGGER.addHandler(handler);   *********   ПО КАКОЙ-ТО    ПРИЧИНЕ   НЕ   ВИДИТ  МЕТОД addHandler

    @Before
    public void  startTest() {
//        LOGGER.log(Level.SEVERE,"Start" + GregorianCalendar.getInstance());
        newMatrix = new NewMatrix();
    }

    @Test
    public void oneFourCheckTest() {
        Assert.assertTrue(onlyOneFour == newMatrix.oneFourCheck(arrs));
    }

//    @After
//    public void endTest () {
//        LOGGER.log(Level.SEVERE, "End" + GregorianCalendar.getInstance());
//    }
}
