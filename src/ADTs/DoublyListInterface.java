package ADTs;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShiouChein
 */
public interface DoublyListInterface <T>{
    void add(T data);
    boolean remove(T data); 
    boolean contains(T anEntry);
    boolean isEmpty();
    int size();
}
