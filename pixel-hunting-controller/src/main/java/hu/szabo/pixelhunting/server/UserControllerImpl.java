package hu.szabo.pixelhunting.server;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hu.szabo.pixelhunting.user.SaveUserRequest;
import hu.szabo.pixelhunting.user.UserResponse;
import hu.szabo.pixelhunting.user.UserRestController;
import hu.szabo.pixelhunting.user.UserService;

@RestController
public class UserControllerImpl implements UserRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);
	
	@Autowired
	private UserService userservice;
	
	@Override
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		LOGGER.debug("BEGIN getAllUsers: {}");
		
		List<UserResponse> userResponse = new ArrayList<>();
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
}
