package hu.szabo.pixelhunting.team;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hu.szabo.pixelhunting.utils.BaseResponse;

@RestController
public class TeamMemberControllerImpl implements TeamMemberRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamControllerImpl.class);

	@Autowired
	private TeamMemberService teamMemberService;
	
	@Override
	public ResponseEntity<TeamMemberResponse> addMemberToTeam(TeamMemberRequest request) {
		LOGGER.debug("BEGIN addMemberToTeam: {}");
		
		if (request == null) {
			String errorMessage = "Request cannot be null";
			LOGGER.error(errorMessage);
			return new ResponseEntity<>(new TeamMemberResponse(Boolean.FALSE, errorMessage), HttpStatus.BAD_REQUEST);
		}
		
		TeamMemberResponse response = null;
		
		try {
			response = teamMemberService.addTeamMemberToTeam(request);
			response.setSuccess(Boolean.TRUE);
			response.setMessage("Succes to save teamMember");
		} catch (Exception e) {
			String errorMessage = "Faild to save team!";
			LOGGER.error(errorMessage, e);
			return new ResponseEntity<>(new TeamMemberResponse(Boolean.FALSE, errorMessage + e), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.debug("END addMemberToTeam, response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BaseResponse> deleteTeamMemberFromTeam(TeamMemberRequest request) {
		LOGGER.debug("BEGIN deleteTeamMemberFromTeam: {}");
		
		if (request == null) {
			String errorMessage = "Request cannot be null";
			LOGGER.error(errorMessage);
			return new ResponseEntity<>(new TeamMemberResponse(Boolean.FALSE, errorMessage), HttpStatus.BAD_REQUEST);
		}
		
		BaseResponse response = new BaseResponse();
		
		try {
			teamMemberService.deleteTeamMemberFromTeam(request.getTeamMemberId());
			response.setSuccess(Boolean.TRUE);
			response.setMessage("Success to delete teamMember from!");
		} catch (Exception e) {
			String errorMessage = "Faild to delete teamMember form team!";
			LOGGER.error(errorMessage, e);
			return new ResponseEntity<>(new BaseResponse(Boolean.FALSE, errorMessage + e), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.debug("END deleteTeamMemberFromTeam, response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TeamMemberResponse>> getTeamMembersByTeam(TeamIdRequest request) {
		
		LOGGER.debug("BEGIN getTeamMembersByTeam: {}");
		
		List<TeamMemberResponse> response = new LinkedList<>();
		
		if (request.getTeamId() == null) {
			String errorMessage = "Request cannot be null";
			LOGGER.error(errorMessage);
			response.add(new TeamMemberResponse(Boolean.FALSE, errorMessage));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			response = teamMemberService.getTeamMemberByTeamId(request.getTeamId());
		} catch (Exception e) {
			String errorMessage = "Failed to get teamMember by teamId!";
			LOGGER.error(errorMessage, e);
			response.add(new TeamMemberResponse(Boolean.FALSE, errorMessage));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.debug("END getTeamMembersByTeam, response: {}", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
