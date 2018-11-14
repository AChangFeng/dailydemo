package wind.datastruct;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-11-14 14:47
 **/
public class ArrayQueue {

    private String[] items;

    private int capacity;

    private int head;

    private int tail;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String val) {
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < capacity; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            // head -= head;
            head = 0;
        }
        items[tail++] = val;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String item = items[head++];
        return item;
    }
}