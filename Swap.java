
//**********************************************************************************************************
//1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
//**************************************************************************************************************


class SwapShow {

     private static Object[] swap ( int ind1, int ind2, Object[] obj) {
        //if (ind1 >= obj.length || ind2 >= obj.length || ind1 < 0 || ind2 < 0)
       try { Object v = obj[ind1];
        obj[ind1] = obj[ind2];
        obj[ind2] = v;}
       catch (IndexOutOfBoundsException e) {
           System.out.println("Index Out Of Bounds " + obj.getClass().getSimpleName() + " " + e.getMessage());
       }
        return obj;
    }

     public static void main(String[] args) {

        Integer [] inums = {1, 2, 3, 4, 5};
        Cat[] cats = { new Cat("first"), new Cat("second")};

        swap(2, 3, inums);
         for (int i = 0; i < inums.length; i++) {
             System.out.println(inums[i]);
         }


         swap(-1, 1, cats);
         for (int i = 0; i < cats.length; i++) {
             System.out.println(cats[i].toString());
             System.out.println(cats[i].getClass());
             System.out.println(cats[i] instanceof Object);
         }

     }


}

class Cat {
    String name;
    Cat (String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return this.name;
    }
}

