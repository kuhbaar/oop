import java.lang.annotation.*;
//Runtime, damit man die Authoren mittels Reflektion bestimmen können (siehe letzter Punkt beim Testen)
//ElementType.METHOD - annotation für Methoden
@AuthorClass(author="Jakub Zarzycki")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AuthorMethod{
  String author() default "none";
}