package myunit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// annotation to mark methods to be run before each test
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD})   
public @interface BeforeTest {
}