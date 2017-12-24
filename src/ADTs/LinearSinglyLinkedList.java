package ADTs;

import java.io.Serializable;

/**
 * @author Tan Qi Han
 */
public class LinearSinglyLinkedList<T> implements ListInterface<T>, Serializable {

    public class Node implements Serializable {

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
    private Node firstNode;
    private int numberOfEntries = 0;

    public LinearSinglyLinkedList() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            Node temp = firstNode;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean added = true;

        if (newPosition > 0 && newPosition <= numberOfEntries) {
            Node newNode = new Node(newEntry);

            if (numberOfEntries == 0 || newPosition == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;

            }
            numberOfEntries++;
        } else {
            added = false;
        }
        return added;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            numberOfEntries--;

        }
        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean successful = true;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            successful = false;
        }
        return successful;

    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }

        return found;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if (numberOfEntries == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

}
