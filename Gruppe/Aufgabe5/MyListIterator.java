import java.util.Iterator;

public interface MyListIterator<T> extends Iterator<T> {
  public boolean hasNext();

  public T next();

  public <E extends T> void add(E o);
  public void remove();
}