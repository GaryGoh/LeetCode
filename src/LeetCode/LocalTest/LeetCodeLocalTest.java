package LeetCode.LocalTest;

import java.lang.reflect.Method;

public class LeetCodeLocalTest<E> extends AbstractLocalTestFramework<E> {

    public LeetCodeLocalTest(Object object) {
        super(object);
    }

    public LeetCodeLocalTest(Object object, Method method1, Method method2) {
        super(object, method1, method2);
    }

    public LeetCodeLocalTest(Object object, String method1, Class type1, String method2, Class type2) throws NoSuchMethodException {
        super(object, method1, type1, method2, type2);
    }
}
