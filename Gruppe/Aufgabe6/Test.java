import java.util.ArrayList;

public class Test {
  public static void main(String[] args) {
    ArrayList<Actor> actors = new ArrayList<Actor>();
    actors.add(new Actor("pistole", 1337));

    Android a = new Kaempfer("007", new HochfesterSkin(),
      new KaempferSoftware("007", new Sicherheitsstufe5()), actors);

    actors = new ArrayList<Actor>();
    actors.add(new Actor("staubsauger", 1));

    Android b = new Hilfskraft("001", new GepanzerterSkin(),
      new HilfskraftSoftware("001", new Sicherheitsstufe1()), actors);

    AndroidList list = new AndroidList();
    expect(list.insert(a), true, "gueltiger kaempfer");
    expect(list.insert(b), false, "falscher skin");
  }

  public static void expect(boolean a, boolean b, String msg) {
    if(a != b)
      System.out.println("!!! FAIL: " + msg + " !!!");
    else
      System.out.println("  success");
  }

}
