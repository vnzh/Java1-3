
//**********************************************************
//2. Написать метод, который преобразует массив в ArrayList;
//*************************************************************

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayToArrayList <T> {

    private ArrayList<T> arrayList;

     private  <T>   ArrayList arrayToArrayList (T[] ar){
//         ArrayList<T> tArrayList = new ArrayList<T>();
//         for (int i = 0; i < ar.length; i++) {
//             tArrayList.add(ar[i]);
//         }
         ArrayList<T> tArrayList =
                 new ArrayList<T>(Arrays.asList(ar));
         return tArrayList;
    }



    public static void main(String[] args) {
        String[] str = {"1", "2", "3", "4", "5"};
        ArrayToArrayList test = new ArrayToArrayList();
        test.arrayList = test.arrayToArrayList(str);
//        arrayList = arrayToArrayList(str);


        System.out.println(test.arrayList.toString());
///         Выдает ошибку java.lang.NullPointerException при выполнении
//        ArrayToArrayList test2 = new ArrayToArrayList();
//        Collections.addAll(test2.arrayList, str);
//        System.out.println(test2.arrayList.toString());

    }


}
