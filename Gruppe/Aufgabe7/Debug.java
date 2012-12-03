public class Debug {
  private final static boolean debug = false;

  public static void info(String msg) {
    if(debug) System.out.println(msg);
  }

  public static void error(String msg) {
    if(debug) System.err.println(msg);
  }
}
