import java.util.NoSuchElementException;

@AuthorClass(author="Julian Schrittwieser")
public class Some implements MaybeNumber {
  private final Number n;

  public Some(Number n) {
    this.n = n;
  }

  public boolean isDefined() { return true; }
  public Number get() { return n; }
  public Number getOrElse(Number standard) { return n; }
}
