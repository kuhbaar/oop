package myunit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// annotation to mark methods to be run when the class with the tests is created
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD})   
public @interface BeforeClass {
}