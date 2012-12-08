import java.lang.annotation.*;
//Runtime, damit man die Authoren mittels Reflektion bestimmen können (siehe letzter Punkt beim Testen)
@Retention(RetentionPolicy.RUNTIME)
@Target(value=METHOD)
public @interface Author{
  String author() default "none";
}