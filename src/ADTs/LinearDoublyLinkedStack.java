package ADTs;
// Tan Qi Han
// RSD2 G2
// 17WMR09515

public class LinearDoublyLinkedStack<T> implements StackInterface<T> {

    private Node topNode;

    @Override
    public void push(T newEntry) {
        if (isEmpty()) {//to check whether the stack is empty
            Node newNode = new Node(newEntry);
            topNode = newNode;
            topNode.next = null;
            topNode.previous = null;
        } else {
            Node newNode = new Node(newEntry, topNode, null); //assign the pointer between each other    
            topNode.previous = newNode;
            topNode = newNode;//newNode becom ethe new top
        }
    }

    @Override
    public T pop() {
        if (!isEmpty()) {//if the stack is not empty
            T data = topNode.data;
            topNode = topNode.next;//second Node become the new top     
            return data;
        }
        return null;
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return topNode.data;//return the top value but without remove it
        } else {
            return null;
        }

    }

    @Override
    public boolean isEmpty() {
        if (topNode == null)//to check whether the top is empty or not
        {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        while (!isEmpty()) {//to remove all the pointing between each other
            Node temp = topNode;
            topNode = topNode.next;
            topNode.previous = null;
            temp.next = null;
        }
    }

    private class Node {

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