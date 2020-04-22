import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Logger;


//***********************************
//testing class  for  task  1
//*************************************
public class TestNewMatrix {
    private NewMatrix newMatrix;



    @Before
    public void startTest() {
        newMatrix = new NewMatrix();

    }
    @Test
    public void testMatrix (){
        Assert.assertArrayEquals(new int[] {1, 7}, newMatrix.newMatrix(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7 }));
    }

    @Test(expected = NoRightElementsException.class)
    public void testMatrix2 (){
        Assert.assertArrayEquals(new int[] {1, 7}, newMatrix.newMatrix(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 4 }));

    }

    @Test
    public void testMatrix3 (){
        Assert.assertArrayEquals(new int[] {2, 3, 2, 2, 3, 8, 1, 7},
                newMatrix.newMatrix(new int[] {4, 2, 3, 2, 2, 3, 8, 1, 7}));
    }

    @Test (expected = RuntimeException.class)
    public void testMatrix4 (){

        Assert.assertArrayEquals(new int[] {2, 3, 2, 2, 3, 8, 1, 7},
                newMatrix.newMatrix(new int[] {1, 2, 3, 2, 2, 3, 8, 1, 7}));
    }

}

