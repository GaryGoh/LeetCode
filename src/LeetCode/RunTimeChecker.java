package LeetCode;

import java.util.concurrent.Callable;

/**
 * Created by mgao on 2018/4/10.
 */
public class RunTimeChecker {
    public Runnable runtimeChecker(Callable f) {
        return new Runnable() {
            @Override
            public void run() {
                long startTime = System.nanoTime();
                try {
                    f.call();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println(f.toString() + " - Runtime:" + totalTime + "ns");
            }
        };
    }
}
