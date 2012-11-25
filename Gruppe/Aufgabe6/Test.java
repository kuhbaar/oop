public class Test {
  public static void main(String[] args) {
    Android a = new Kaempfer("007", new HochfesterSkin(), new KaempferSoftware("007", 5));

    Inspector i = new Inspector();
    a.accept(i);
  }

}
