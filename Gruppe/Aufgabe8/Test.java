import java.lang.annotation.*;
import java.lang.reflect.*;

public class Test{
  public static void main(String[] args){
    Traktor t1 = new DieselTraktor("diesi");
    Traktor t2 = new BiogasTraktor("biogasi");

    /*Auslesen wer welche Klassen/Methoden*/
    String s = "";
    AuthorClass a = Traktor.class.getAnnotation(AuthorClass.class);
    if(a != null) 
      s += a.author() + " wrote Traktor";
    s += "\nwith Methods from:\n";

    Method[] ma = Traktor.class.getMethods();
    for(Method m : ma){
      AuthorMethod am = m.getAnnotation(AuthorMethod.class);
      if(am != null){
        s += am.author() + " wrote Method " + m + "\n";
      }
    }
    System.out.println(s);
  }
}