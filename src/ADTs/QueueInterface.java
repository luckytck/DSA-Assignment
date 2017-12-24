
package ADTs;

/**
 * QueueInterface.java An interface for the ADT queue.
 *
 * @author Tan Cheong Kiat
 * @version 1.0
 */
public interface QueueInterface<T> {
    /**
   * Task: Adds a new entry to the back of the queue.
   *
   * @param newEntry an object to be added
   */
  public void enqueue(T newEntry);

  /**
   * Task: Removes and returns the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty before the operation, null
   */
  public T dequeue();

  /**
   * Task: Retrieves the entry at the front of the queue.
   *
   * @return either the object at the front of the queue or, if the queue is
   * empty, null
   */
  public T getFront();

  /**
   * Task: Detects whether the queue is empty.
   *
   * @return true if the queue is empty, or false otherwise
   */
  public boolean isEmpty();

  /**
   * Task: Removes all entries from the queue.
   */
  public void clear();
  
  /**
   * Task: Gets the number of entries in the queue.
   *
   * @return the integer number of entries currently in the queue
   */
  public int getNumberOfEntries();
}
