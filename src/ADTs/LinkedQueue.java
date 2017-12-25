package ADTs;

import java.io.Serializable;

/**
 *
 * @author ShiouChein
 */
public class LinkedQueue<T> implements QueueInterface<T>, Serializable {

    private Node firstNode, lastNode;
    private int numberOfEntries;

    private class Node implements Serializable {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedQueue() {
        clear();
    }

    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        Node oldRear = lastNode;
        lastNode = newNode;
        lastNode.data = newEntry;
        lastNode.next = null;

        if (isEmpty()) {
            firstNode = lastNode;
        } else {
            oldRear.next = lastNode;
        }

        numberOfEntries++;
    }

    @Override
    public T dequeue() {
        T data = null;
        data = firstNode.data;
        firstNode = firstNode.next;

        if (isEmpty()) {
            lastNode = null;
        }

        numberOfEntries--;
        return data;
    }

    @Override
    public T getFront() {
        T data = null;
        if (!isEmpty()) {
            data = firstNode.data;
        }
        return data;
    }

    //check is this queue empty?
    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public static void main(String[] args) {
        QueueInterface<Integer> test = new LinkedQueue<>();

        test.enqueue(123);
        test.enqueue(145);
        System.out.println(test.dequeue());
        System.out.println("Front:" + test.getFront());
    }
}