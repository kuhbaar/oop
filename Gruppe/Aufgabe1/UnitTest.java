import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

// annotation to mark methods to be run as a unittest
@Retention(RetentionPolicy.RUNTIME) // Make this annotation accessible at runtime via reflection.
@Target({ElementType.METHOD})       // This annotation can only be applied to class methods.
@interface UnitTest {
}


// annotation to mark methods to be run when the class with the tests is created
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD})   
@interface BeforeClass {
}

// annotation to mark methods to be run when the class with the tests is created
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD})   
@interface AssertThrows {
  Class exception();
}