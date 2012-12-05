
/* _maybe_ contains a value. (this is like null, but done properly in a typesafe
   way). This also means that null won't ever be used anywhere in this program,
   and no function takes a null value. Or returns one. Ever. */
public abstract class Maybe<T> {
  /* true if it contains a value, false otherwise */
  abstract public boolean isDefined();

  /* returns the value if there is one, otherwise throws an exception */
  abstract public T get() throws java.util.NoSuchElementException;

  /* returns the value if there is one, otherwise returns the passed default value */
  abstract public T getOrElse(T fallback);
}
