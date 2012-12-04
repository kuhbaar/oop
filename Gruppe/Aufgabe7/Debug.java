public class Debug {
  private final static boolean debug = false;

  private static String getLocation() {
    StackTraceElement l = new Throwable().getStackTrace()[2];
    return l.getFileName()+", "+l.getClassName()+"/"+l.getMethodName()+":"+l.getLineNumber();
  }

  public static void info(String msg) {
    if(debug) System.out.println(String.format("%s @ %s: %s",
      Thread.currentThread().getName(), getLocation(), msg));
  }

  public static void error(String msg) {
    if(debug) System.err.println(msg);
  }
}
