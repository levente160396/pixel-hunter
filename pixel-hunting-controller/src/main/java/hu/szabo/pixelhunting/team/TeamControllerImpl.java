package hu.szabo.pixelhunting.team;

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
public class TeamControllerImpl implements TeamRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamControllerImpl.class);
	
	@Autowired
	private TeamService teamService;

	@Override
	public ResponseEntity<List<TeamResponse>> getAllTeam() {
		LOGGER.debug("BEGIN getAllTeam: {}");
		
		List<TeamResponse> teamsResponse = new LinkedList<>();
		
		try {
			teamsResponse = teamService.getAllTeams();
		} catch (Exception e) {
			String errorMessage = "Faild to get all teams!";
			LOGGER.error(errorMessage, e);
		}
		
		LOGGER.debug("END getAllTeam, response: {}", teamsResponse);
		return new ResponseEntity<>(teamsResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TeamResponse> saveTeam(TeamRequest request) {
		LOGGER.debug("BEGIN saveTeam: {}", request);
		
		if (request == null) {
			String errorMessage = "Request cannot be null";
			LOGGER.error(errorMessage);
			return new ResponseEntity<>(new TeamResponse(Boolean.FALSE, errorMessage), HttpStatus.BAD_REQUEST);
		}
		
		TeamResponse response = null;
		
		try {
			response = teamService.saveTeam(request);
			response.setSuccess(Boolean.TRUE);
			response.setMessage("Succes save Team!");
		} catch (Exception e) {
			String errorMessage = "Faild to save team!";
			LOGGER.error(errorMessage, e);
		}
		
		LOGGER.debug("END saveTeam, response: {}", response);
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
