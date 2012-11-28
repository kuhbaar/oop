import java.util.ArrayList;
import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    AndroidList list = new AndroidList();

    Android kaempfer = new Kaempfer("007", new HochfesterSkin(),
      new KaempferSoftware("007", new Sicherheitsstufe5()),
      Arrays.asList(new Actor("pistole", 1337)));

    expectSuccess(list.insert(kaempfer), "gueltiger kaempfer");


    Android bauarbeiter = new Bauarbeiter("008", new HochfesterSkin(),
      new BauarbeiterSoftware("008", new Sicherheitsstufe3()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expectSuccess(list.insert(bauarbeiter), "gueltiger bauarbeiter");


    bauarbeiter = new Transportarbeiter("008", new HochfesterSkin(),
      new TransportarbeiterSoftware("008", new Sicherheitsstufe3()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expectSuccess(list.insert(bauarbeiter), "gueltiges update des bauarbeiters");


    bauarbeiter = new Transportarbeiter("008", new HochfesterSkin(),
      new TransportarbeiterSoftware("008", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("greifarm", 4.8)));

    expectFailure(list.insert(bauarbeiter), "ungueltiges update des bauarbeiters - sicherheitsstufe geandert");


    bauarbeiter = new Gesellschafter("008", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("008", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("greifarm", 0.8)));

    expectFailure(list.insert(bauarbeiter), "ungueltiges update des bauarbeiters - type geaendert");


    Android hilfskraft = new Hilfskraft("001", new GepanzerterSkin(),
      new HilfskraftSoftware("001", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("staubsauger", 0.8)));

    expectFailure(list.insert(hilfskraft), "falscher skin");


    Android gesellschafter = new Gesellschafter("010", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("010", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("faecher", 0.8)));

    expectSuccess(list.insert(gesellschafter), "gueltiger Gesellschafter");


    Android gesellschafter2 = new Gesellschafter("011", new BeruehrungsSensitiverSkin(),
      new GesellschafterSoftware("011", new Sicherheitsstufe1()),
      Arrays.asList(new Actor("faecher", 1.1)));

    expectFailure(list.insert(gesellschafter2), "ungueltiger Gesellschafter - leistung zu hoch");


    Android servicetechniker = new ServiceTechniker("012", new HochfesterSkin(),
      new ServiceTechnikerSoftware("011", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("loetbrenner", 2.45), new Actor("schweissgeraet", 3.1)));

    expectSuccess(list.insert(servicetechniker), "gueltiger ServiceTechniker");

    servicetechniker = new ServiceTechniker("012", new HochfesterSkin(),
      new ServiceTechnikerSoftware("011", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("loetbrenner", 5.45), new Actor("schweissgeraet", 5.1)));

    expectFailure(list.insert(servicetechniker), "gueltiger ServiceTechniker - leistung zu hoch");

    Android bewacher = new Objektbewacher("013", new BeruehrungsSensitiverSkin(),
      new ObjektbewacherSoftware("011", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("pistole", 3.4), new Actor("energieschild", 5.3)));

    expectSuccess(list.insert(bewacher), "gueltiger Objektbewacher");

    bewacher = new Objektbewacher("013", new BeruehrungsSensitiverSkin(),
      new ObjektbewacherSoftware("011", new Sicherheitsstufe5()),
      Arrays.asList(new Actor("pistole", 3.4), new Actor("energieschild", 5.3)));

    expectFailure(list.insert(bewacher), "ungueltiger Objektbewacher - falsche sicherheitsstufe");

    bewacher = new Objektbewacher("013", new BeruehrungsSensitiverSkin(),
      new KaempferSoftware("011", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("pistole", 3.4), new Actor("energieschild", 5.3)));

    expectFailure(list.insert(bewacher), "ungueltiger Objektbewacher - falsche software");

    Android leibwaechter = new Leibwaechter("014", new HochfesterSkin(),
      new LeibwaechterSoftware("014", new Sicherheitsstufe4()),
      Arrays.asList(new Actor("CPR", 4.5), new Actor("laser", 5.5)));

    expectSuccess(list.insert(leibwaechter), "gueltiger leibwaechter");

    leibwaechter = new Leibwaechter("014", new GepanzerterSkin(),
      new LeibwaechterSoftware("014", new Sicherheitsstufe5()),
      Arrays.asList(new Actor("CPR", 4.5), new Actor("laser", 5.5)));

    expectFailure(list.insert(leibwaechter), "ungueltiger leibwaechter - falsche sicherheitsstufe");
  }

  public static void expectSuccess(boolean a, String msg) {
    expect(true, a, msg);
  }

  public static void expectFailure(boolean a, String msg) {
    expect(false, a, msg);
  }

  public static void expect(boolean a, boolean b, String msg) {
    if(a != b)
      System.out.println("!!! TEST FAILED: " + msg + " !!!");
    else
      System.out.println("  test succeeded");
  }

}
