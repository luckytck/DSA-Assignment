package ADTs;

import java.io.Serializable;

/**
 * @author Wong Li Yi
 */
public class LinearDoublyLinkedList<T> implements LinearDoublyListInterface<T>, Serializable {

    private Node firstNode, lastNode;
    private int numberOfEntries;

    public LinearDoublyLinkedList() {
        clear();
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.previous = lastNode;
        }
        lastNode = newNode;

        numberOfEntries++;
    }

    @Override
    public boolean remove(T anEntry) {
        if (firstNode == null) {
            return false;
        }

        boolean found = false;
        Node temp = firstNode;
        while (temp != null && !found) {
            if (temp.data.equals(anEntry)) {
                found = true;
            } else {
                temp = temp.next;
            }
        }

        if (!found) {
            return false;
        } else {
            if (firstNode == lastNode) {
                firstNode = lastNode = null;

            } else if (temp.previous == null) {
                firstNode = temp.next;
                firstNode.previous = null;

            } else if (temp == lastNode) {
                lastNode = temp.previous;
                lastNode.next = null;
            } else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
            return true;

        }
    }

    @Override
    public boolean contains(T anEntry) {
        Node temp = firstNode;
        while (temp != null) {
            if (temp.data.equals(anEntry)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        }
        return false;
    }

    @Override
    public T getEntry(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node nodeCurrent = firstNode;
            for (int i = 1; i <= givenPosition - 1; i++) {
                nodeCurrent = nodeCurrent.next;
            }
            data = nodeCurrent.data;
        }
        return data;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public String toString() {
        String str = "";
        Node temp = firstNode;
        while (temp != null) {
            str += temp.data + " ";
            temp = temp.next;
        }
        return str;
    }

    private class Node implements Serializable {

        T data;
        Node next, previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

    }

}
