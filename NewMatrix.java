

public class NewMatrix {


    public static void main(String[] args) {

    }
//***********************************************************************************************************
//    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
//    иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
//    (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
//    ********************************************************************************************************

    public int[] newMatrix (int[] original) {
        int[] newArray;
        int indexMatch = -1;
        for (int i = original.length -1; i >= 0; i--) {
            if (original[i] == 4) {
                indexMatch = i;
                break;
            }
        }//for

        if (indexMatch == -1) throw new RuntimeException();
        if (indexMatch == (original.length - 1)) throw new NoRightElementsException();
        int newArrayLenght = (original.length - 1) - indexMatch;
        newArray = new int[newArrayLenght];
        System.arraycopy(original, indexMatch + 1, newArray, 0,
                newArrayLenght);

    return newArray;
    }//newMatrix

//***********************************************************************************
//    2. Написать метод, который проверяет состав массива из чисел 1 и 4.
//    Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 //*****************************************************************************************

    public boolean oneFourCheck (int[] pattern){
        boolean hasOne = false;
        boolean hasFour = false;
        for (int i = 0; i < pattern.length-1; i++) {

            switch (pattern[i]) {
                case 1: hasOne = true; break;
                case 4: hasFour = true; break;
                default: return false;
            }
        }
        if (hasOne == false || hasFour == false) return false;

        return true;
    }

}

class NoRightElementsException extends NullPointerException {

}
