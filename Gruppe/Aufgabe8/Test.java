import java.lang.annotation.*;
import java.lang.reflect.*;

public class Test{
  public static void main(String[] args){
    Traktor t1 = new DieselTraktor("diesi");
    Traktor t2 = new BiogasTraktor("biogasi");

    printClassInfo(Traktor.class);
    printClassInfo(DieselTraktor.class);
    printClassInfo(BiogasTraktor.class);
    printClassInfo(MyMap.class);
  }

  public static void printClassInfo(Class cls) {
    /*Auslesen wer welche Klassen/Methoden*/
    String s = "";
    Annotation[] classAnnotations = cls.getAnnotations();
    for(Annotation o : classAnnotations) {
      if(o instanceof AuthorClass) {
        AuthorClass a = (AuthorClass) o;
        if(a != null)
          s += a.author() + " wrote " + cls.getName() + " with Methods:\n";

        Method[] ma = cls.getMethods();
        for(Method m : ma) {
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
