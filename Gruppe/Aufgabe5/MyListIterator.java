import java.util.Iterator;

public interface MyListIterator<T> extends Iterator<T> {
  public boolean hasNext();
  public boolean hasPrevious();

  public T next();
  public T previous();

  public <E extends T> void add(E o);
  public void remove();
}