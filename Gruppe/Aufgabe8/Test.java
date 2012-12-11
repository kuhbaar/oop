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

  @AuthorMethod(author="Julian Schrittwieser")
  public static void main(String[] args){
    addHof(new Bauernhof("ponyhof"));
    addHof(new Bauernhof("pferdehof"));
    addHof(new Bauernhof("schweinezucht"));
    addHof(new Bauernhof("getreidefarm"));

    getHof("getreidefarm").addTraktor(new BiogasTraktor("gas-1"));
    getHof("getreidefarm").addTraktor(new BiogasTraktor("gas-2"));
    getHof("getreidefarm").addTraktor(new DieselTraktor("diesel-1"));

    getHof("getreidefarm").incrStunden("diesel-1");
    getHof("getreidefarm").changeTraktor("diesel-1", new DuengerStreuer(23.3));


    getHof("pferdehof").addTraktor(new BiogasTraktor("gas-1"));
    getHof("pferdehof").addTraktor(new DieselTraktor("diesel-1"));

    for(Object key : hoefe) {
      Bauernhof b = getHof(key);
      System.out.println("==== " + b.getName());
      System.out.println("-- Durschnittliche Betriebsstunden");
      System.out.println("   gesamt:  " + b.getHoursComplete());
      System.out.println("   saeen:   " + b.getHoursSow());
      System.out.println("   duengen: " + b.getHoursDrill());
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
