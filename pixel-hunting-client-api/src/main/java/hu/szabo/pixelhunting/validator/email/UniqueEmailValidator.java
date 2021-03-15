package hu.szabo.pixelhunting.validator.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import hu.szabo.pixelhunting.user.UserService;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !userService.isEmailExist(value);
	}
}
