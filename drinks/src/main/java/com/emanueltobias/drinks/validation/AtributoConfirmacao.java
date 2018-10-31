package com.emanueltobias.drinks.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import com.emanueltobias.drinks.validation.validator.AtributoConfirmacaoValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { AtributoConfirmacaoValidator.class })
public @interface AtributoConfirmacao {
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "As senhas não correspondem";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String atributo();
	String atributoConfirmacao();
	
	
}
