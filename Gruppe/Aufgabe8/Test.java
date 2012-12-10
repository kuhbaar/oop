import java.lang.annotation.*;
import java.lang.reflect.*;

@AuthorClass(author="Julian Schrittwieser")
public class Test{
  @AuthorMethod(author="Jakub Zarzycki")
  public static void main(String[] args){
    Traktor t1 = new DieselTraktor("diesi");
    Traktor t2 = new BiogasTraktor("biogasi");


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
