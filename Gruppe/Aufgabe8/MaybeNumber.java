import java.util.NoSuchElementException;

public interface MaybeNumber {
  public boolean isDefined();
  public Number get() throws NoSuchElementException;
  public Number getOrElse(Number standard);
}
