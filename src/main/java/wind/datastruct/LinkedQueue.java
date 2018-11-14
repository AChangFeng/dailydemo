package wind.datastruct;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-11-14 14:59
 **/
public class LinkedQueue {

    private int size;

    private Node head;

    private Node tail;

    public boolean enqueue(String val) {
        Node newNode = new Node();
        newNode.val = val;
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    public String dequeue() {
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            tail = null;
        }
        String ret = head.val;
        head = head.next;
        size--;
        return ret;
    }


    class Node {
        String val;
        Node next;
    }
}