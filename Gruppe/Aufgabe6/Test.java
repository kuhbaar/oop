import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Android a = new Kaempfer("007", new HochfesterSkin(),
      new KaempferSoftware("007", new Sicherheitsstufe5()));

    ArrayList<Android> list = new ArrayList<Android>();
    Inspector i = new Inspector(list);
    a.accept(i);
  }

}
