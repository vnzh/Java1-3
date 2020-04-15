//
////Попытка  решить    через   один класс для потоков. Идея такая:
//// через статическую   переменную   private static char  aChar класса
//// определять, какаю букву печатать.
//// Идея  потерпела неудачу -   статическая переменная не изменялась!!!!
//
//
//
//public class Lesson4 {
//   public static final Object myObject = new Object();
//    public static void main(String[] args) {
//
//
//        MyThred thredA = new MyThred(myObject,'A');
//        MyThred thredB = new MyThred(myObject,'B');
//        MyThred thredD = new MyThred(myObject,'C');
//
//       new Thread(thredA).start();
//       new Thread(thredB).start();
//       new Thread(thredD).start();
//    }
//}
//
//class MyThred implements Runnable {
//    private static char  aChar = 'A';
//    Object myObject;
//    private char threadChar;
//
//    public MyThred(Object myObject, char threadChar) {
//        this.myObject = myObject;
//        this.threadChar = threadChar;
//    }
//
//    /**
//     * When an object implementing interface <code>Runnable</code> is used
//     * to create a thread, starting the thread causes the object's
//     * <code>run</code> method to be called in that separately executing
//     * thread.
//     * <p>
//     * The general contract of the method <code>run</code> is that it may
//     * take any action whatsoever.
//     *
//     * @see Thread#run()
//     */
//    @Override
//    public void run() {
//        synchronized (myObject) {
//            for (int i = 0; i < 5; i++) {
//                while (threadChar != aChar) {
//                    try {
//                        myObject.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println(aChar);
////                aChar  = (MaChar > 67) ? 65: aChar++;
//                setaChar();
//                myObject.notifyAll();
//            }
//        }
//    }
//
//    public static void  setaChar() {
//        aChar  = (aChar > 67) ? 65: aChar++;
//    }
//}//MyThread
//
//
//
