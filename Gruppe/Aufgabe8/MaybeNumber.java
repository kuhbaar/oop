import java.util.NoSuchElementException;

@AuthorClass(author="Julian Schrittwieser")
public interface MaybeNumber {
  public boolean isDefined();
  public Number get() throws NoSuchElementException;
  public Number getOrElse(Number standard);
}
