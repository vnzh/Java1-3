import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestThred extends Thread {

  private   Method before, test, after;
  private   Object testClass;

    public TestThred(Method before, Method test, Method after, Object testClass) {
        super();
        this.before = before;
        this.test = test;
        this.after = after;
        this.testClass = testClass;
    }

    public void run() {
                   try {

                if (before != null) {

                    before.invoke(testClass);
                    System.out.println(Thread.currentThread().getName() + " test: Befoe done ");
                    test.invoke(testClass);
                    System.out.println(Thread.currentThread().getName() + " test: Test done  ");
                } else {
                    test.invoke(testClass);
                }
                if (after != null) {
                    after.invoke(testClass);
                    System.out.println(Thread.currentThread().getName() + " test: After done  " );
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

    }
}