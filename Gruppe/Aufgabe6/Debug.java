public class Debug {
  private static final boolean debug = false;

  public static void println(String msg) {
    if(debug) System.out.println(msg);
  }
}
