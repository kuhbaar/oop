import java.util.ArrayList;
import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    AndroidList list = new AndroidList();

    Android kaempfer = new Kaempfer("007", new HochfesterSkin(),
      new KaempferSoftware("007", new Sicherheitsstufe5()),
      Arrays.asList(new Actor("pistole", 1337)));

    expect(list.insert(kaempfer), true, "gueltiger kaempfer");


    Android bauarbeiter = new Bauarbeiter("008", new HochfesterSkin(),
      new BauarbeiterSoftware("008", new Sicherheitsstufe3()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expect(list.insert(bauarbeiter), true, "gueltiger bauarbeiter");


    bauarbeiter = new Transportarbeiter("008", new HochfesterSkin(),
      new TransportarbeiterSoftware("008", new Sicherheitsstufe3()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expect(list.insert(bauarbeiter), true, "gueltiges update des bauarbeiters");


    bauarbeiter = new Transportarbeiter("008", new HochfesterSkin(),
      new TransportarbeiterSoftware("008", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expect(list.insert(bauarbeiter), false, "ungueltiges update des bauarbeiters");


    bauarbeiter = new Gesellschafter("008", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("008", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("greifarm", 0.8)));

    expect(list.insert(bauarbeiter), false, "ungueltiges update des bauarbeiters");


    Android hilfskraft = new Hilfskraft("001", new GepanzerterSkin(),
      new HilfskraftSoftware("001", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("staubsauger", 0.8)));

    expect(list.insert(hilfskraft), false, "falscher skin");
    

    Android gesellschafter = new Gesellschafter("010", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("010", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("faecher", 0.8)));

    expect(list.insert(gesellschafter), true, "gueltiger Gesellschafter");


    Android gesellschafter2 = new Gesellschafter("011", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("011", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("faecher", 1.1)));

    expect(list.insert(gesellschafter2), false, "ungueltiger Gesellschafter");

  }

  public static void expect(boolean a, boolean b, String msg) {
    if(a != b)
      System.out.println("!!! FAIL: " + msg + " !!!");
    else
      System.out.println("  success");
  }

}
