package taoqi.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-11 10:07
 **/
public class SynchronousQueueDemo {

    public static void main(String[] args) throws Exception {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "producer");
        Thread consumer = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        }, "consumer");
        consumer.start();
        System.out.println(Thread.currentThread().getName()+" started consumer thread and will sleep for 2 seconds");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName()+" awake and will start producer thread");
        producer.start();
    }
}