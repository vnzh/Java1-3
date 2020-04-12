//***********************************************************************************************
// Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
// Вводим страницу (за страницу можно принять 1800 символов),
// программа выводит ее в консоль. Контролируем время выполнения:
// программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
//

import java.io.*;


public class LessonTask3 {

    public static void main(String[] args) throws FileNotFoundException {

        Pages book = new Pages(new FileReader("D:\\txt\\Evgenij_Onegin.txt"));
        book.readPage();

//    Resalt
//        It took 0 to read the page
//        It took 63 to out the page
//        For next page press Enter

    }
}

class Pages {
    private String fileName;
    private FileReader fileReader;
    private long timeStart;
    private long  timeEnd;

    public Pages(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    void readPage () {

        char [] chars = new char[1800];
        int readDone = 0;
        while (true) {
            timeStart = System.currentTimeMillis();
            try {
                if (!fileReader.ready()) break;
                readDone  = fileReader.read(chars);

            } catch (IOException e) {
                e.printStackTrace();
            }
        outputConsol(chars,readDone);
        }
    }

    void outputConsol (char[] chars, int outFor) {
        timeEnd = System.currentTimeMillis();
        for (int i = 0; i < outFor; i++) {
            System.out.print(chars[i]);
        }

        System.out.println();
        System.out.println();
        System.out.printf("It took %d to read the page \n", (timeEnd - timeStart));
        System.out.printf("It took %d to out the page\n", (System.currentTimeMillis() - timeEnd));
        System.out.println("For next page press Enter");
         InputStreamReader reader = new InputStreamReader(System.in);
        try {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
