/* subclass of Maybe that doesn't contain a value */
public class None<T> extends Maybe<T> {
  /* always false, there is no value */
  public boolean isDefined() {
    return false;
  }

  /* always throws an exception, again no value here */
  public T get() throws java.util.NoSuchElementException {
    throw new java.util.NoSuchElementException();
  }

  /* always returns the default */
  public T getOrElse(T fallback) {
    return fallback;
  }
}
