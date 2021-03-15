package hu.szabo.pixelhunting.team;

import java.util.ArrayList;
import java.util.List;

public class TeamMemberMapperImpl implements TeamMemberMapper {

	@Override
	public TeamMemberResponse teamMemberToTeamMemberResponse(TeamMember teamMember) {
		
		TeamMemberResponse teamMemberResponse = new TeamMemberResponse();
		teamMemberResponse.setId(teamMember.getId());
		teamMemberResponse.setTeamId(teamMember.getTeam().getId());
		teamMemberResponse.setUserId(teamMember.getUser().getId());
		teamMemberResponse.setTeamMemberType(teamMember.getTeamMemberType());
		
		return teamMemberResponse;
	}

	@Override
	public List<TeamMemberResponse> teamMembersToTeamMemberResponse(List<TeamMember> teamMembers) {
		List<TeamMemberResponse> results = new ArrayList<>(teamMembers.size());
		
		for (TeamMember teamMember : teamMembers) {
			TeamMemberResponse teamMemberResponse = new TeamMemberResponse();
			teamMemberResponse.setId(teamMember.getId());
			teamMemberResponse.setTeamId(teamMember.getTeam().getId());
			teamMemberResponse.setUserId(teamMember.getUser().getId());
			teamMemberResponse.setTeamMemberType(teamMember.getTeamMemberType());
			results.add(teamMemberResponse);
		}
		
		return results;
	}

}
