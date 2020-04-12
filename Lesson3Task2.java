//********************************************************************
// Последовательно сшить 5 файлов в один (файлы примерно 100 байт)
// Может пригодиться следующая конструкция:
// ArrayList<InputStream> al = new ArrayList<>(); ...
// Enumeration<InputStream> e = Collections.enumeration(al);
//***************************************************************************


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Lesson3Task2 {
    public  static ArrayList<FileInputStream> streams = new ArrayList<>();
   // public static Enumeration<FileInputStream> enumeration = Collections.enumeration(streams);


    private static String fileOne = "D:\\txt\\1.txt";
    private static String fileTwo = "D:\\txt\\2.txt";
    private static String fileThree ="D:\\txt\\3.txt";
    private static String fileFour = "D:\\txt\\4.txt";
    private static String fileFife = "D:\\txt\\5.txt";


    public static void main(String[] args) throws IOException {
            streams.add(new FileInputStream(fileOne));
            streams.add(new FileInputStream(fileTwo));
            streams.add(new FileInputStream(fileThree));
            streams.add(new FileInputStream(fileFour));

            // Как  я понимаю,   если  инициализировать  потоки в ArrayList<FileInputStream> streams
        // сразу при создании, то  файлы  будут заблокированы,  на поддержание потоков будут расходоваться ресурсы
        // по этой причине  инициализировать  их  лучше  перед самым использованием.

        Enumeration<FileInputStream> enumeration = Collections.enumeration(streams);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
        FileOutputStream  outputStream = new FileOutputStream(fileFife, true);
        byte[]  bytes = new byte[1000];
        int readDone = 0;
        while (sequenceInputStream.available() > 0) {
             readDone = sequenceInputStream.read(bytes);
             outputStream.write(bytes, 0, readDone);
        }
        sequenceInputStream.close();
   }

}
