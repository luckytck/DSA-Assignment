package ADTs;

import java.io.Serializable;

/**
 * @author Tan Cheong Kiat
 */
public class SortedDoublyLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T>, Serializable {

    private Node firstNode;
    private int numberOfEntries;

    private class Node implements Serializable {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.next != null && newEntry.compareTo(currentNode.data) > 0) {
                currentNode = currentNode.next;
            }
            if (currentNode.previous == null) {//Add at the first position
                newNode.next = firstNode;
                firstNode.previous = newNode;
                firstNode = newNode;
            } else if (newEntry.compareTo(currentNode.data) > 0) {//Add at the last position
                currentNode.next = newNode;
                newNode.previous = currentNode;
            } else {//Add at the middle
                Node nodeBefore = currentNode.previous;
                nodeBefore.next = newNode;
                newNode.previous = nodeBefore;
                newNode.next = currentNode;
                currentNode.previous = newNode;
            }
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (currentNode != null && !found) {
            if (anEntry.compareTo(currentNode.data) == 0) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        if (found) {
            removeCurrentNode(currentNode);
            numberOfEntries--;
        }
        return found;
    }

    @Override
    public int getPosition(T anEntry) {;
        int position = 1;
        Node currentNode = firstNode;
        while (position <= numberOfEntries && anEntry.compareTo(currentNode.data) >= 0){
            if (anEntry.compareTo(currentNode.data) == 0) {
                return position;
            }
            position++;
            currentNode = currentNode.next;
        }
        return -position;
    }

    @Override
    public T getEntry(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 1; i <= givenPosition - 1; i++) {
                currentNode = currentNode.next;
            }
            data = currentNode.data;
        }
        return data;
    }

    @Override
    public boolean contains(T anEntry) {
        boolean isContains = false;
        for (int i = 1; i <= numberOfEntries; i++) {
            if (getEntry(i) == anEntry) {
                isContains = true;
            }
        }
        return isContains;
    }

    @Override
    public T remove(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 1; i <= givenPosition - 1; i++) {
                currentNode = currentNode.next;
            }
            data = currentNode.data;
            removeCurrentNode(currentNode);
            numberOfEntries--;
        }
        return data;
    }

    @Override
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getLength() {
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
    public boolean isFull() {
        return false;
    }

    private void removeCurrentNode(Node currentNode) {
        if (currentNode.previous == null && currentNode.next == null) {//Remove only node
            firstNode = null;
        } else if (currentNode.previous == null) {//Remove first node
            firstNode = firstNode.next;
            firstNode.previous = null;
        } else if (currentNode.next == null) {//Remove last node
            Node nodeBefore = currentNode.previous;
            nodeBefore.next = null;
            currentNode.previous = null;
        } else {//Remove middle node
            Node nodeBefore = currentNode.previous;
            Node nodeAfter = currentNode.next;
            nodeBefore.next = nodeAfter;
            nodeAfter.previous = nodeBefore;
        }
    }
}
