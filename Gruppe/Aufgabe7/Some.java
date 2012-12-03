public class Some<T> extends Maybe<T> {
  private final T elem;
  public Some(T e) {
    this.elem = e;
  }

  public boolean isDefined() {
    return true;
  }

  public T get() throws java.util.NoSuchElementException {
    return elem;
  }

  public T getOrElse(T other) {
    return elem;
  }
}
