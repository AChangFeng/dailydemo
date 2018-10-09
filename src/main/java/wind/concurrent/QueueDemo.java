package wind.concurrent;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-11 15:43
 **/
public class QueueDemo {

    public static void main(String[] args) {
        demoRetrieveElementsFromQueue();
    }

    public static void demoInsertElementsToQueue() {
        Queue<Integer> queue4Insert = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue4Insert.add(i);
        }
        try {
            System.out.println(queue4Insert.add(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(queue4Insert.offer(10));
    }

    public static void demoRetrieveElementsFromQueue() {
        Queue<Integer> queue4Retrieve = new PriorityBlockingQueue<>();
        try {
            System.out.println(queue4Retrieve.remove());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(queue4Retrieve.poll());
        try {
            System.out.println(queue4Retrieve.element());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(queue4Retrieve.peek());
    }

}