
package ADTs;

import java.io.Serializable;


public class LinearDoublyLinkedList<T> implements ListInterface<T>,Serializable {

    private Node firstNode;
    private Node lastNode;
    private Node temp;
    private int numberOfEntries;
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            
        } else {
            lastNode = firstNode.next;
            lastNode.next = newNode;
            newNode.previous = lastNode;
            lastNode = newNode;

        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        Node newNode = new Node(newEntry);
        boolean isAdded = false;
        if (newPosition >= 1 && newPosition <= numberOfEntries + 1) {
            if (isEmpty() || newPosition == 1) {
                firstNode = newNode;
               
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                newNode.previous = nodeBefore;
                nodeBefore.next = newNode;
                nodeAfter.previous = newNode;
            }
            numberOfEntries++;
            isAdded = true;
        }
        return isAdded;
        
    }

    @Override
    public T remove(int givenPosition) {
        T data = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                data = firstNode.data;
                firstNode =null;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; i++) {
                    nodeBefore = nodeBefore.next;
                }
                data = nodeBefore.next.data;
                Node nodeAfter = nodeBefore.next.next;
                nodeBefore.next = nodeAfter;
                nodeAfter.previous = nodeBefore;
            }
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
    public boolean replace(int givenPosition, T newEntry) {
         boolean isReplaced = false;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node nodeCurrent = firstNode;
            for (int i = 1; i <= givenPosition - 1; i++) {
                nodeCurrent = nodeCurrent.next;
            }
            nodeCurrent.data = newEntry;
            isReplaced = true;
        }
        return isReplaced;
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
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if(firstNode == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    public class Node implements Serializable{
        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data,Node next,Node previous ) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }
    
    
    
}
