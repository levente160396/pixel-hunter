package hu.szabo.pixelhunting.team;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.szabo.pixelhunting.utils.BaseResponse;

@RestController
@RequestMapping(path = "/api/team-member")
public interface TeamMemberRestController {
	
	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<TeamMemberResponse> addMemberToTeam(@RequestBody TeamMemberRequest request);

	@RequestMapping(method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<BaseResponse> deleteTeamMemberFromTeam(@RequestBody TeamMemberRequest request);
	
	@RequestMapping(method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<List<TeamMemberResponse>> getTeamMembersByTeam(@RequestBody TeamIdRequest request);

}
