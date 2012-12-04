/* subclass of maybe that contains a value */
public class Some<T> extends Maybe<T> {
  private final T elem;
  public Some(T e) {
    this.elem = e;
  }

  /* always true since Some contains a value */
  public boolean isDefined() {
    return true;
  }

  /* always returns the element */
  public T get() throws java.util.NoSuchElementException {
    return elem;
  }

  /* always returns the element */
  public T getOrElse(T fallback) {
    return elem;
  }
}
