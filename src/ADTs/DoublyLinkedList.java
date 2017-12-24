package ADTs;



import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShiouChein
 */
public class DoublyLinkedList <T> implements DoublyListInterface<T>,Serializable{

    private Node firstNode, lastNode;
    private int size;

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

    @Override
    public void add(T data) {
        Node temp = new Node(data,null,lastNode);
        if(lastNode != null){
            lastNode.next = temp;
        }
        lastNode = temp;
        if(firstNode == null){
            firstNode = temp;
        }
        
        size ++;
    }

    @Override
    public boolean remove(T data) {
        if(firstNode == null)
            return false;
        
        boolean found = false;
        Node temp = firstNode;
        
        while(temp != null && !found){ //found == false is equal to !found
            if(temp.data.equals(data))
                found = true;
            else
                temp = temp.next;
        }
        
        if(!found)
            return false;
        else{
            if(firstNode == lastNode){ //remove 1 and only node
                firstNode = lastNode = null;
            }
            else if(temp.previous == null){ //remove 1st node
                firstNode = temp.next; //firstNode = firstNode.next;
                firstNode.previous = null;
            }
            else if(temp == lastNode){
                lastNode = temp.previous; //lastnode = lastNode.previous;
                lastNode.next = null;
            }
            else { //remove middle node
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
            size --;
            return true;
        }
    }

    @Override
    public boolean contains(T anEntry) {
        Node temp = firstNode;
        while(temp != null){
            if(temp.data.equals(anEntry))
                return true;
            else
                temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        DoublyListInterface<Integer> test = new DoublyLinkedList<Integer>();
        
        test.add(10);
        test.add(20);
        test.add(30);
        test.add(100);
        test.remove(20);
        
        System.out.println("Size:" + test.size());
        System.out.println("Contains 20? " + test.contains(20));
    }
}
