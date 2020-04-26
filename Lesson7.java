
//**********************************************************
//1. Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов
// с аннотациями @Test. Для этого у него должен быть статический метод start(),
// которому в качестве параметра передается или объект типа Class, или имя класса.
// Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite,
// если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех тестов –
// метод с аннотацией @AfterSuite. К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
// в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый,
// то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
// в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
//*********************************************************

import java.lang.reflect.Method;






public class Lesson7 {

    //********************************************
// Пояснения    работы программы
//    class DoSomting  -   образец   класса, который  проводит  тесты.
//    class TestThred extends Thread класс, в котором    проводится   проверка   теста  метода
//    class Lesson7  -   в методе  старт  проводится   работы  по разборке   class DoSomting
//    ********************************************************




    private   Method before, test, after;
    private   Object testClass;


//    private static Class someClass = DoSomting.class;

    public static void main(String[] args) {


        start(DoSomting.class.getName());
    }

    public static void start(String nameClass) {

        Class clazz = null;
        DoSomting testClass = null;
        try {
            clazz = Class.forName(nameClass);
            testClass = (DoSomting) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Method[] methods = clazz.getDeclaredMethods();

// флаги наличия   более одного   Предметода или Послеметода  и индексы  их нахождения  в массиве
        boolean hasTwoBefore = false;
        int twoBefore = -1;
        boolean hasTwoAfter = false;
        int twoAfter = -1;

        //  проверка  на   количетсво    Предметодов  и Послеметодов

        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getAnnotation(AfterSuite.class) != null && hasTwoAfter == true) {
                throw new RuntimeException("Too more AfterSuite");
            }
            if (methods[i].getAnnotation(BeforeSuite.class) != null && hasTwoBefore == true) {
                throw new RuntimeException(" Too more BeforeSuite");
            }
            if (methods[i].getAnnotation(AfterSuite.class) != null) {
                hasTwoAfter = true;
                twoAfter = i;
                continue;
            }
            if (methods[i].getAnnotation(BeforeSuite.class) != null) {
                hasTwoBefore = true;
                twoBefore = i;
            }
        }
            Method before = null;
            Method after = null;
            if (twoBefore != -1) {before = methods[twoBefore];}
            if (twoAfter != -1)  {after = methods[twoAfter];}

        for (int i = 0; i < methods.length; i++) {
//               int mark = 0;
            if (i == twoAfter || i == twoBefore) {
                continue;
            }
//            testDoing(before, methods[i], after, testClass);

            TestThred testThred = new TestThred(before, methods[i], after, testClass);
//
            testThred.setPriority(methods[i].getAnnotation(Test.class).priotity());
            testThred.setName(methods[i].getName());
            testThred.start();

        }
    }//start

    //   сделано   для  промежуточного тестирования      проведение   теста
//    public void testDoing  (Method before, Method test, Method after, Object testClass) {
//
//        try {
//
//            if (before != null) {
//
//                before.invoke(testClass);
//                System.out.println(Thread.currentThread().getName() + " test: Befoe done ");
//                test.invoke(testClass);
//                System.out.println(Thread.currentThread().getName() + " test: Test done  ");
//            } else {
//                test.invoke(testClass);
//            }
//            if (after != null) {
//                after.invoke(testClass);
//                System.out.println(Thread.currentThread().getName() + " test: After done  ");
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }


}//class




