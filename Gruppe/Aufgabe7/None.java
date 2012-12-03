public class None<T> extends Maybe<T> {
  public boolean isDefined() {
    return false;
  }

  public T get() throws java.util.NoSuchElementException {
    throw new java.util.NoSuchElementException();
  }

  public T getOrElse(T other) {
    return other;
  }
}
