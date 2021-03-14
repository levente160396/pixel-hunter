package hu.szabo.pixelhunting.user;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);
	
	@Autowired
	private UserService userservice;
	
	@Override
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		LOGGER.debug("BEGIN getAllUsers: {}");
		
		List<UserResponse> userResponse = new LinkedList<>();
		try {
			
			userResponse = userservice.findAllUser();
			
		} catch (Exception e) {
			String errorMessage = "Faild to getAllUsers!";
			LOGGER.error(errorMessage, e);
		}
		
		LOGGER.debug("END getAllUsers, response: {}", userResponse);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserResponse> registerUser(SaveUserRequest request) {
		LOGGER.debug("BEGIN saveUser: {}", request);

		if (request == null) {
			String errorMessage = "Request cannot be null";
			LOGGER.error(errorMessage);
			return new ResponseEntity<>(new UserResponse(Boolean.FALSE, errorMessage), HttpStatus.BAD_REQUEST);
		}
		
		if(userservice.isEmailExist(request.getEmail()) || userservice.isUsernameExist(request.getUsername())) {
			String errorMessage = "Email or username are not unique!";
			LOGGER.error(errorMessage);
			return new ResponseEntity<>(new UserResponse(Boolean.FALSE, errorMessage), HttpStatus.BAD_REQUEST);
		}
		
		UserResponse response = new UserResponse();
		
		try {
			response = userservice.saveUser(request);
		}catch (Exception e) {
			String errorMessage = "Faild to save User!";
			LOGGER.error(errorMessage, e);
		}

		LOGGER.debug("END saveUser, response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public static Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
