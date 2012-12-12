import java.lang.annotation.*;
import java.lang.reflect.*;

@AuthorClass(author="Jakub Zarzycki")
public class Test{

  private static MyMap hoefe = new MyMap();

  @AuthorMethod(author="Julian Schrittwieser")
  private static Bauernhof getHof(Object name) {
    Object o = hoefe.get(name);
    if(o instanceof Bauernhof) {
      return (Bauernhof) o;
    } else {
       throw new RuntimeException("invalid state - this.hoefe should only "
        + "contain values of type Bauernhof");
    }
  }

  @AuthorMethod(author="Julian Schrittwieser")
  private static void addHof(Bauernhof hof) {
    hoefe.put(hof.getName(), hof);
  }

  @AuthorMethod(author="Julian Schrittwieser, Jakub Zarzycki")
  public static void main(String[] args){
    addHof(new Bauernhof("ponyhof"));
    addHof(new Bauernhof("pferdehof"));
    addHof(new Bauernhof("schweinezucht"));
    addHof(new Bauernhof("getreidefarm"));

    getHof("getreidefarm").addTraktor(new BiogasTraktor("gas-1", new DuengerStreuer(1.5)));
    getHof("getreidefarm").addTraktor(new BiogasTraktor("gas-2", new DrillMaschine(1)));
    getHof("getreidefarm").addTraktor(new DieselTraktor("diesel-1", new DrillMaschine(2)));
    getHof("getreidefarm").changeStunden("diesel-1", 5);
    getHof("getreidefarm").changeTraktor("diesel-1", new DuengerStreuer(23.3));
    getHof("getreidefarm").changeVerbrauch("diesel-1", 15);
    getHof("getreidefarm").delTraktor("gas-1");
    getHof("getreidefarm").changeStunden("gas-2", 10);
    getHof("getreidefarm").changeVerbrauch("gas-2", 10.0);

    getHof("pferdehof").addTraktor(new BiogasTraktor("gas-1", new DrillMaschine(3)));
    getHof("pferdehof").addTraktor(new BiogasTraktor("gas-2", new DuengerStreuer(5.3)));
    getHof("pferdehof").addTraktor(new DieselTraktor("diesel-1", new DuengerStreuer(2.3)));
    getHof("pferdehof").changeVerbrauch("diesel-1", 7);
    getHof("pferdehof").changeStunden("diesel-1", 12);
    getHof("pferdehof").changeVerbrauch("diesel-1", 23);
    getHof("pferdehof").changeVerbrauch("gas-1", 43.123);
    getHof("pferdehof").changeVerbrauch("gas-2", 87.23);

    getHof("ponyhof").addTraktor(new BiogasTraktor("gas-1", new DuengerStreuer(5.2)));
    getHof("ponyhof").addTraktor(new DieselTraktor("diesel-1", new DrillMaschine(9)));
    getHof("ponyhof").addTraktor(new DieselTraktor("diesel-2", new DuengerStreuer(7.1)));
    getHof("ponyhof").changeVerbrauch("diesel-1", 2);
    getHof("ponyhof").changeStunden("diesel-1", 7);
    getHof("ponyhof").changeVerbrauch("diesel-1", 3);
    getHof("ponyhof").changeVerbrauch("gas-1", 26.93);
    getHof("ponyhof").changeStunden("gas-1", 6);
    getHof("ponyhof").changeVerbrauch("diesel-2", 9);
    getHof("ponyhof").changeStunden("diesel-2", 10);


    for(Object key : hoefe) {
      Bauernhof b = getHof(key);
      System.out.println("==== " + b.getName());

      if(b.getNumTraktors() == 0) {
        System.out.println("Dieser Bauernhof hat keine Traktoren\n");
        continue;
      }

      System.out.println("-- Durschnittliche Betriebsstunden");
      System.out.println("   alle:    " + b.getHoursComplete());
      System.out.println("   saeen:   " + b.getHoursDuenger());
      System.out.println("   duengen: " + b.getHoursDrill());
      System.out.println("   diesel:  " + b.getHoursDiesel());
      System.out.println("   biogas:  " + b.getHoursBiogas());
      System.out.println("-- Durschnittlicher Dieselverbrauch");
      System.out.println("   alle:    " + b.getDiesel());
      System.out.println("   saeen:   " + b.getDieselDrill());
      System.out.println("   duengen: " + b.getDieselDuenger());
      System.out.println("-- Durschnittlicher Gasverbrauch");
      System.out.println("   alle:    " + b.getGas());
      System.out.println("   saeen:   " + b.getGasDrill());
      System.out.println("   duengen: " + b.getGasDuenger());
      System.out.println("-- minimale Saescharanzahl");
      System.out.println("   alle:    " + b.getMinSaeschere());
      System.out.println("   diesel:  " + b.getMinSaeschereDiesel());
      System.out.println("   biogas:  " + b.getMinSaeschereGas());
      System.out.println("-- maximale Saescharanzahl");
      System.out.println("   alle:    " + b.getMaxSaeschere());
      System.out.println("   diesel:  " + b.getMaxSaeschereDiesel());
      System.out.println("   biogas:  " + b.getMaxSaeschereGas());
      System.out.println("-- durchschnittliche Duengerkapazitaet");
      System.out.println("   alle:    " + b.getCapacity());
      System.out.println("   diesel:  " + b.getCapacityDiesel());
      System.out.println("   biogas:  " + b.getCapacityGas());
      System.out.println();
    }

    printClassInfo(AuthorClass.class);
    printClassInfo(AuthorMethod.class);

    printClassInfo(Traktor.class);
    printClassInfo(DieselTraktor.class);
    printClassInfo(BiogasTraktor.class);

    printClassInfo(Maschine.class);
    printClassInfo(DrillMaschine.class);
    printClassInfo(DuengerStreuer.class);

    printClassInfo(Bauernhof.class);

    printClassInfo(MyMap.class);

    printClassInfo(None.class);
    printClassInfo(MaybeNumber.class);
    printClassInfo(Some.class);

    printClassInfo(Test.class);
  }

  public static void printClassInfo(Class cls) {
    /*Auslesen wer welche Klassen/Methoden*/
    String s = "";
    for(Annotation o : cls.getAnnotations()) {
      if(o instanceof AuthorClass) {
        AuthorClass a = (AuthorClass) o;
        if(a != null)
          s += a.author() + " wrote " + cls.getName() + " with Methods:\n";

        for(Method m : cls.getMethods()) {
          if(m.getDeclaringClass().equals(cls)) {
            AuthorMethod am = m.getAnnotation(AuthorMethod.class);
            if(am != null){
              s += "\t" + am.author() + " wrote Method " + m + "\n";
            } else {
              /* if method isn't annotated, it was written by the class' author */
              s += "\t" + a.author() + " wrote Method " + m + "\n";
            }
          }
        }
        System.out.println(s);
      }
    }

  }
}
