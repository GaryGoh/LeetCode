package LeetCode.LocalTest;

import org.junit.Assert;

import java.lang.reflect.Method;
import java.util.List;

public class AbstractLocalTestFramework<E> implements LocalTestFramework<E> {

    private Object object;
    private Method method1;
    private Method method2;

    AbstractLocalTestFramework(Object object) {
        this.object = object;
    }

    AbstractLocalTestFramework(Object object, Method method1, Method method2) {
        this.object = object;
        this.method1 = method1;
        this.method2 = method2;
    }


    AbstractLocalTestFramework(Object object, String method1, Class type1, String method2, Class type2) throws NoSuchMethodException {
        this.object = object;
        this.method1 = object.getClass().getDeclaredMethod(method1, type1);
        this.method2 = object.getClass().getDeclaredMethod(method2, type2);
    }

    @Override
    public void run(Method method1, Method method2, List<E> testSet) {
        try {
            for (E testcase : testSet) {
                Assert.assertEquals(method1.invoke(object, testcase),
                        method2.invoke(object, testcase));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public long runWithRuntime(Method method1, Method method2, List<E> testSet) {
        long before = System.currentTimeMillis();
        run(method1, method2, testSet);
        long after = System.currentTimeMillis();
        return after - before;
    }

    public long runWithRuntime(List<E> testSet) {
        long before = System.currentTimeMillis();
        run(method1, method2, testSet);
        long after = System.currentTimeMillis();
        return after - before;
    }
}
