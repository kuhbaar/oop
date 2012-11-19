public class Description implements Shorter<Description> {
  private final String text;

  public Description(String text) {
    this.text = text;
  }

  public String toString() { return this.text; }

  public boolean shorter(Description o) {
    return this.toString().length() < o.toString().length();
  }

  public int numberOfLines() {
    return this.text.split("\n").length;
  }
}