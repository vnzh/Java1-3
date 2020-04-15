
////Попытка  решить    через   один класс для потоков. Идея такая:
//// через статическую   переменную     объекта Монитора
//// определять, какаю букву печатать.
//// Идея  потерпела неудачу -   статическая переменная не изменялась!!!!

public class ObjectControl {

        public static final MyObject myObject = new MyObject();
        public static void main(String[] args) {


            MyThred thredA = new MyThred(myObject,'A');
            MyThred thredB = new MyThred(myObject,'B');
            MyThred thredD = new MyThred(myObject,'C');

            new Thread(thredA).start();
            new Thread(thredB).start();
            new Thread(thredD).start();
        }
    }

    class MyThred implements Runnable {

        MyObject myObject;
        private char threadChar;
//        private String threadName;

        public MyThred(MyObject myObject, char threadChar) {
            this.myObject = myObject;
            this.threadChar = threadChar;
            Thread.currentThread().setName("" + threadChar + threadChar);

        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

            synchronized (myObject) {
                for (int i = 0; i < 5; i++) {
                    while (threadChar != myObject.getaChar()) {
                        try {
                            myObject.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                   // System.out.println(myObject.getaChar());
                    System.out.println(Thread.currentThread().getName());
//                aChar  = (MaChar > 67) ? 65: aChar++;
//                    myObject.setaChar(Thread.currentThread().getName().toString());
                    myObject.notifyAll();
                }
            }
        }


    }//MyThread

 class MyObject {
    private static char  aChar = 'A';

    public  char getaChar() {
        return aChar;
    }

    public  void  setaChar() {
        aChar  = (aChar > 67) ? 65: aChar++;


    }
}

