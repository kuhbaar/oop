import java.util.NoSuchElementException;

/* Interface used to unite the return Types of Numbers (like Double/Integer) */
@AuthorClass(author="Julian Schrittwieser")
public interface MaybeNumber {
  /* returns true if defined ( = if instance of Some class) and
    false if instance of None class */
  public boolean isDefined();

  /* if defined returns the class variable
    else throws an NoSuchElementException */
  public Number get() throws NoSuchElementException;

  /* used to check whether or not there's a class variable:
    there's one - returns the class variable (return value != standard)
    there isn't any - returns standard */
  public Number getOrElse(Number standard);
}
