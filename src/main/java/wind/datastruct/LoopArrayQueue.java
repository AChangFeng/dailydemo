package wind.datastruct;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-11-14 15:07
 **/
public class LoopArrayQueue {

    private String[] items;

    private int capacity;

    private int head;

    private int tail;

    private int size;

    public LoopArrayQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String val) {
        if (size == capacity) {
            return false;
        }
        if (tail == capacity) {
            tail = 0;
        }
        items[tail++] = val;
        size++;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        if (head == capacity) {
            head = 0;
        }
        String item = items[head++];
        size--;
        return item;
    }
}