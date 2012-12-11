import java.lang.annotation.*;
import java.lang.reflect.*;

@AuthorClass(author="Jakub Zarzycki")
public class Test{
  @AuthorMethod(author="Julian Schrittwieser")
  public static void main(String[] args){
    Traktor t1 = new DieselTraktor("diesi");
    Traktor t2 = new BiogasTraktor("biogasi");

    MyMap hoefe = new MyMap();
    hoefe.put("ponyhof", new Bauernhof("ponyhof"));
    hoefe.put("pferdehof", new Bauernhof("pferdehof"));
    hoefe.put("schweinezucht", new Bauernhof("schweinezucht"));
    hoefe.put("getreidefarm", new Bauernhof("getreidefarm"));

    ((Bauernhof) hoefe.get("getreidefarm")).addTraktor(new BiogasTraktor("gas-1"));
    ((Bauernhof) hoefe.get("getreidefarm")).addTraktor(new BiogasTraktor("gas-2"));
    ((Bauernhof) hoefe.get("getreidefarm")).addTraktor(new DieselTraktor("diesel-1"));

    ((Bauernhof) hoefe.get("getreidefarm")).getTraktor("diesel-1").incrStunden();
    ((Bauernhof) hoefe.get("getreidefarm")).changeTraktor("diesel-1",
      new DuengerStreuer(23.3));


    ((Bauernhof) hoefe.get("pferdehof")).addTraktor(new BiogasTraktor("gas-1"));
    ((Bauernhof) hoefe.get("pferdehof")).addTraktor(new DieselTraktor("diesel-1"));

    for(Object key : hoefe) {
      Object o = hoefe.get(key);
      if(o instanceof Bauernhof) {
        Bauernhof b = (Bauernhof) o;
        System.out.println("==== " + b.getName());
        System.out.println("-- Durschnittliche Betriebsstunden");
        System.out.println("   gesamt:  " + b.getHoursComplete());
        System.out.println("   saeen:   " + b.getHoursSow());
        System.out.println("   duengen: " + b.getHoursDrill());
        System.out.println();
      }
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
