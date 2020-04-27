import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Lesson8 {

   private static int[][] matrix = new int[7][7];
   private static Coordinates coordinates;
   private static int count = 1;
   private  static int countrecur = 1;

    public static void main(String[] args) {



          fillMatrix();
          printMatrix();
          fillMatrixRec(0, 0);
          printMatrix();

    }


    public static void fillMatrixRec (int startX, int  startY){

        if (countrecur > matrix.length * matrix.length) return;
        // to right
        for (int i = 0 + startX; i < matrix[startY].length -startY; i++) {
            matrix[startY][i] = countrecur++;
        }

        //to down
        for (int i = startY + 1; i < matrix.length -startY; i++) {
            matrix[i][matrix.length-startX-1] = countrecur++;
        }

        //to  left
        for (int i = matrix[matrix.length-startY-1].length-startX-2; i >=startX; i--) {
            matrix[matrix.length-startY-1][i] = countrecur++;
        }

        // up
        for (int i = matrix.length-startY-2; i > startY; i--) {
            matrix[i][startX] = countrecur++;
        }


        fillMatrixRec(startX + 1, startY + 1);
    }


//to fill matrix - my  first  version
    public static void fillMatrix () {
        //  to  first    we   fill  upper  row
         coordinates = new Coordinates(matrix.length-1, 0);

        for (int i = 0, j = 1; i < matrix[0].length; i++, j++) {
            matrix[0][i] = j;
        }
        printMatrix();
        Direct direction = Direct.DOWN;
        int maxcount = matrix.length * matrix.length;
        count = matrix.length;
        // when  we  fill  row  or column  we  change  direction  and   start  to fill next
        while (count < maxcount) {

            switch (direction) {
                case RIGHT: direction = fillMatrixRight(coordinates.y, matrix[coordinates.y][coordinates.x]); break;
                case LEFT: direction = fillMatrixLeft(coordinates.y, matrix[coordinates.y][coordinates.x]); break;
                case UP: direction = fillMatrixUp(coordinates.x, matrix[coordinates.y][coordinates.x]); break;
                case DOWN: direction = fillMatrixDown(coordinates.x, matrix[coordinates.y][coordinates.x]); break;
                default: break;
            }
        }
    }


    public  static Direct fillMatrixRight (int row, int current) {


        for (int i = coordinates.getX()+1, j = 1; i < matrix[row].length; i++, j++) {
            if (matrix[row][i] != 0) {
                return Direct.DOWN;
            }
            matrix[row][i] = current + j;
            coordinates.setX(i);
            count++;
        }
        return Direct.DOWN;
    }

    public  static  Direct  fillMatrixLeft(int row, int current) {

        for (int i = coordinates.getX()-1, j = 1; i >=0; i--, j++) {
            if (matrix[row][i] != 0) {
                return Direct.UP;
            }
            matrix[row][i] = current + j;
            coordinates.setX(i);
            count++;
        }
        return Direct.UP;

    }

    public static Direct fillMatrixDown (int column, int current) {
        for (int i = coordinates.getY()+1, j = 1; i < matrix.length; i++, j++) {
            if (matrix[i][column] != 0) {
                return  Direct.LEFT;
            }
            matrix[i][column] = current + j;
            coordinates.setY(i);
            count++;
        }
        return  Direct.LEFT;
    }

    public static Direct fillMatrixUp (int column, int current) {
        for (int i = coordinates.getY()-1, j = 1; i >=0; i--, j++) {
            if (matrix[i][column] != 0) {
                return Direct.RIGHT;
            }
            matrix[i][column] = current + j;
            coordinates.setY(i);
            count++;
        }
        return Direct.RIGHT;
    }
//coordinates
    public static class Coordinates {

        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
//  to print  matrix
    public  static  void  printMatrix () {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.printf("\n\n");
    }


}
