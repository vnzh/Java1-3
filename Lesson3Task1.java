import java.io.*;

//********************************************************************************
//Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
//********************************************************************************
public class Lesson3Task1 {


    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\txt\\1.txt");
        byte []  bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
//        ByteArrayInputStream inputStream =  new ByteArrayInputStream(bytes);

        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + "  ");
        }


    }




}
