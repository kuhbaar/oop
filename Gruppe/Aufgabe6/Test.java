import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    Android a = new Kaempfer("007", new HochfesterSkin(),
      new KaempferSoftware("007", new Sicherheitsstufe5()));

    AndroidList list = new AndroidList();
    System.out.println(list.insert(a));
  }

}
