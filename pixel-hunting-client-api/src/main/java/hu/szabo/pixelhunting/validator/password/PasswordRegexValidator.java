package hu.szabo.pixelhunting.validator.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordRegexValidator implements ConstraintValidator<PasswordRegex, String> {

	public static final Pattern PASSWORD_REGEX = 
		    Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value != null) {
			Matcher matcher = PASSWORD_REGEX.matcher(value);
			return matcher.find();
		}
		return false;
	}
	
}
