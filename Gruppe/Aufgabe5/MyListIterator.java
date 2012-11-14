public interface MyListIterator<T> {
  public boolean hasNext();

  public T next();

  public <E extends T> void add(E o);
  public void remove();
}