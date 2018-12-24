package LeetCode.LocalTest;

import java.lang.reflect.Method;
import java.util.List;

public interface LocalTestFramework<E> {
    void run(Method method1, Method method2, List<E> testSet);

    long runWithRuntime(Method method1, Method method2, List<E> testSet);

}
