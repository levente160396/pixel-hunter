package hu.szabo.pixelhunting.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class TeamMapperImpl implements TeamMapper {

	@Override
	public List<TeamResponse> teamsToTeamResponse(List<Team> teams) {
		
		if(CollectionUtils.isEmpty(teams)) {
			return Collections.emptyList();
		}
		
		List<TeamResponse> teamsResponse = new ArrayList<TeamResponse>(teams.size());
		for (Team team : teams) {
			TeamResponse teamResponse = new TeamResponse();
			teamResponse.setId(team.getId());
			teamResponse.setName(team.getName());
			teamResponse.setDescription(team.getDescription());
			teamResponse.setModDate(team.getModDate());
			teamResponse.setRecDate(team.getRecDate());
			teamResponse.setRecUserId(team.getRecUserId());
			
			teamsResponse.add(teamResponse);
		}
		
		return teamsResponse;
	}

	@Override
	public Team teamRequestToTeam(TeamRequest teamRequest) {
		Team team = new Team();
		team.setId(teamRequest.getModiflyId());
		team.setName(teamRequest.getName());
		team.setDescription(teamRequest.getDescription());
		team.setRecUserId(teamRequest.getRecUserId());
		
		return team;
	}

	@Override
	public TeamResponse teamToTeamResponse(Team team) {
		
		TeamResponse teamResponse = new TeamResponse();
		teamResponse.setId(team.getId());
		teamResponse.setName(team.getName());
		teamResponse.setDescription(team.getDescription());
		teamResponse.setRecUserId(team.getRecUserId());
				
		return teamResponse;
	}

}
