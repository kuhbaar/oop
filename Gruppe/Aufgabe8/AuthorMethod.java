import java.lang.annotation.*;
//Runtime, damit man die Authoren mittels Reflektion bestimmen können (siehe letzter Punkt beim Testen)
//ElementType.METHOD - annotation für Methoden
@AuthorClass(author="Jakub Zarzycki")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuthorMethod{
  /* defines the Author of the given Method */
  String author() default "none";
}