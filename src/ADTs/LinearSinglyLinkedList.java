package ADTs;

import java.io.Serializable;

/**
 * @author Tan Qi Han & ShiouChein
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
            firstNode = newNode; //If firstNode is null, then add the newEntry into firstNode
        } else {
            Node temp = firstNode;
            while (temp.next != null) { //Add the newEntry at the end of list
                temp = temp.next;
            }
            temp.next = newNode;
        }
        numberOfEntries++;  //Increment the size of the list
        return true;        //Return true when the newEntry is added successfully
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean added = true;

        if (newPosition > 0 && newPosition <= numberOfEntries) {
            Node newNode = new Node(newEntry);

            if (numberOfEntries == 0 || newPosition == 1) { //If the size of list is empty or the position = 1 
                newNode.next = firstNode; //Add the newEntry into the first position
                firstNode = newNode;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode; //Add the newEntry after the nodeBefore

            }
            numberOfEntries++;  //Increment the size of the list
        } else {
            added = false;  //False when the newEntry doesn't add successfully
        }
        return added;
    }

    @Override
    public T remove(int givenPosition) {    //Remove the data at the given position
        T result = null;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next; //Shift the data to the left
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            numberOfEntries--;  //Decrement the size of the list

        }
        return result;
    }

    @Override
    public void clear() {
        firstNode = null;   //Clear the firstNode  
        numberOfEntries = 0;    //Clear the size of the list
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean successful = true;
        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;    //Replace the given position data with the new entry
        } else {
            successful = false;
        }
        return successful;  //Rturn true when replace successfully

    }

    @Override
    public T getEntry(int givenPosition) {  //Get the current index/position of the data
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
    public boolean contains(T anEntry) {    //Return true when the list contains the particular data
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
    public int getNumberOfEntries() {   //Return the size of the list
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {  //Check whether the list is empty
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
