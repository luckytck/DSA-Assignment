package ADTs;

public interface LinearDoublyListInterface<T> {

    public void add(T newEntry);

    public boolean remove(T anEntry);

    public boolean contains(T anEntry);

    public boolean isEmpty();

    public T getEntry(int givenPosition);

    public int getNumberOfEntries();

    public void clear();

}
