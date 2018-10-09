package wind.concurrent;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-07-23 17:30
 **/
public class ThreadLocalDemo {
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 100).forEach(i -> {
            list.add(i);
        });
        List<List<Integer>> partition = Lists.partition(list, 10);
        AtomicInteger major = new AtomicInteger(0);
        partition.forEach(integers -> {
            executorService.execute(() -> {
                major.getAndIncrement();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + " get>>>" + THREAD_LOCAL.get());
            });
        });
        Thread.sleep(2000);
        System.out.println("major=" + major.get());

    }

}