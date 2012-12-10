import java.lang.Number;

@AuthorClass(author="Julian Schrittwieser")
public abstract class Maschine{
  public MaybeNumber getSaeschere(){ return new None(); }
  public MaybeNumber getBehaelter(){ return new None(); }
}
