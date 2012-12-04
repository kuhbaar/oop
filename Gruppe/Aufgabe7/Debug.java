public class Debug {
  private final static boolean debug = false;

  /* retrieve the callers location from the stack */
  private static String getLocation() {
    StackTraceElement l = new Throwable().getStackTrace()[2];
    return l.getFileName()+", " +l.getMethodName()+"."+l.getLineNumber();
  }

  /* logs an info message to stdout with the following format:
     [info] <threadname> @ <filename>, <methodname>.<lineno>: <msg> */
  public static void info(String msg) {
    if(debug) System.out.println(String.format("[info] %s @ %s: %s",
      Thread.currentThread().getName(), getLocation(), msg));
  }

  /* logs an info message to stderr with the following format:
     [error] <threadname> @ <filename>, <methodname>.<lineno>: <msg> */
  public static void error(String msg) {
    if(debug) System.err.println(String.format("[error] %s @ %s: %s",
      Thread.currentThread().getName(), getLocation(), msg));
  }
}
