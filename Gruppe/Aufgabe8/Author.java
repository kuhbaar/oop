//Runtime, damit man die Authoren mittels Reflektion bestimmen können (siehe letzter Punkt beim Testen)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Author{
  String author() default "none";
}