import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;


@Retention(RetentionPolicy.RUNTIME) // Make this annotation accessible at runtime via reflection.
@Target({ElementType.METHOD})       // This annotation can only be applied to class methods.
@interface UnitTest {
}