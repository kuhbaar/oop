public abstract class Maybe<T> {
  abstract public boolean isDefined();
  abstract public T get() throws java.util.NoSuchElementException;
  abstract public T getOrElse(T other);
}
