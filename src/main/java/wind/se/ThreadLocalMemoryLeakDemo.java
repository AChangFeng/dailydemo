package wind.se;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-22 11:05
 **/
public class ThreadLocalMemoryLeakDemo {

    private static volatile boolean subthreadSet = false;

    public static void main(String[] args) throws Exception {
        ThreadLocal<Memo> local = new ThreadLocal<>();
        ThreadLocal[] threadLocals = new ThreadLocal[1];

        // Thread.sleep(20_000);

        threadLocals[0] = local;

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            threadLocals[0].set(new Memo());
            System.out.println("sub thread set value success");
        });
        local = null;

        //  Thread.sleep(20_000);
        System.out.println("subthread will use another threadlocal");
        executorService.execute(() -> {
            Object o = new ThreadLocal<>().get();
            System.out.println("another operation get is " + (o == null));
        });
    }

}

class Memo {

    private byte[] buf = new byte[1024 * 1024 * 500];

}
