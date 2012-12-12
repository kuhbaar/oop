import java.util.NoSuchElementException;

/* Class used to encapsulate Number values from the Maschines */
@AuthorClass(author="Julian Schrittwieser")
public class Some implements MaybeNumber {
  private final Number n;

  /* creates new Some with n */
  public Some(Number n) {
    this.n = n;
  }

  /* always returns true */
  public boolean isDefined() { return true; }

  /* returns n */
  public Number get() { return n; }

  /* returns n */
  public Number getOrElse(Number standard) { return n; }
}
