import java.util.NoSuchElementException;

public class None implements MaybeNumber {
  public boolean isDefined() { return false; }
  public Number get() { throw new NoSuchElementException(); }
  public Number getOrElse(Number standard) { return standard; }
}
