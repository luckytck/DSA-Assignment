
package ADTs;
// Tan Qi Han
// RSD2 G2
// 17WMR09515
public class LinearDoublyLinkedStack<T> implements StackInterface<T> {

    private Node topNode;   
    @Override
    public void push(T newEntry) {
        
        if (isEmpty()) {
            Node newNode = new Node(newEntry);
             topNode=newNode;
             topNode.next=null;
             topNode.previous=null;
        } else {
            Node newNode = new Node(newEntry,topNode,null);        
           topNode.previous=newNode;
           topNode=newNode;
        }
       
    }

    @Override
    public T pop() {
        
        if(!isEmpty()){
           T data=topNode.data;
            topNode=topNode.next;          
            return data;
        }
        return null;
    }

    @Override
    public T peek() {
      if(!isEmpty()){
          return topNode.data;
      }else
          return null;
        
    }

    @Override
    public boolean isEmpty() {
        if(topNode==null)
            return true;
        else
            return false;
    }

    @Override
    public void clear() {
       while(!isEmpty()){
           Node temp=topNode;
           topNode=topNode.next;
           topNode.previous=null;
           temp.next=null;
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
