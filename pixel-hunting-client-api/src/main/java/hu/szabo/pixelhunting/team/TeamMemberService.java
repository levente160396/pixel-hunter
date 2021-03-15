package hu.szabo.pixelhunting.team;

import java.util.List;

public interface TeamMemberService {

	TeamMemberResponse addTeamMemberToTeam(TeamMemberRequest request);

	void deleteTeamMemberFromTeam(Long teamMemberId);

	List<TeamMemberResponse> getTeamMemberByTeamId(Long teamId);

}
