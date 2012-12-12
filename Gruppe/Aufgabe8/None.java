import java.util.NoSuchElementException;

/* Class used to avoid returning Nulls or 0, where Number is expected */
@AuthorClass(author="Julian Schrittwieser")
public class None implements MaybeNumber {
  
  /* always returns false */
  public boolean isDefined() { return false; }

  /* always throws NoSuchElementException */
  public Number get() { throw new NoSuchElementException(); }

  /* always returns standard */
  public Number getOrElse(Number standard) { return standard; }
}
