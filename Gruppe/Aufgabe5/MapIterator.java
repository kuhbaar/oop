import java.util.Iterator;
import java.util.ListIterator;

public interface MapIterator<T, U> extends Iterator<T> {
  public boolean hasNext();
  public T next();
  public void remove();
  public ListIterator<U> iterator();
}