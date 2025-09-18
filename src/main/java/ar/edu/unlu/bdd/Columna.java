package ar.edu.unlu.bdd;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Columna {
    String nombre() default  "";
}
