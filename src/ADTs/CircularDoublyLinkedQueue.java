package ADTs;

import java.io.Serializable;
/**
 * @author Tan Cheong Kiat
 */
public class CircularDoublyLinkedQueue<T> implements QueueInterface<T>, Serializable {

    private Node firstNode;
    private int numberOfEntries;

    public CircularDoublyLinkedQueue() {
        clear();
    }
    
    private class Node implements Serializable {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public void enqueue(T newEntry) {
        if (isEmpty()) {
            Node newNode = new Node(newEntry);
            firstNode = newNode;
            firstNode.next = firstNode;
            firstNode.previous = firstNode;
        } else {
            Node lastNode = firstNode.previous;
            Node newNode = new Node(newEntry, firstNode, lastNode);
            lastNode.next = newNode;
            firstNode.previous = newNode;
        }
        numberOfEntries++;
    }

    @Override
    public T dequeue() {
        T data = null;
        if (!isEmpty()) {
            data = firstNode.data;
            if (firstNode == firstNode.next) {
                firstNode = null;
            } else {
                Node lastNode = firstNode.previous;
                firstNode = firstNode.next;
                firstNode.previous = lastNode;
                lastNode.next = firstNode;
            }
            numberOfEntries--;
        }
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
    
    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    public static void main(String[] args) {
        QueueInterface<Integer> queue = new CircularDoublyLinkedQueue<>();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
