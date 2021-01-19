package ar.alicode.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = StudentCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } ) 
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentCode {
	
	String value() default "ALI";
	String message() default "must start with ALI";
	
	// define default groups
	Class<?> [] groups() default {};
	
	// define default payloads
	Class<? extends Payload>[] payload() default {};
	
}
