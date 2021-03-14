package hu.szabo.pixelhunting.team;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {

	TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);
	
	List<TeamResponse> teamsToTeamResponse(List<Team> teams);
	
	Team teamRequestToTeam(TeamRequest teamRequest);
	
	TeamResponse teamToTeamResponse(Team team);
}
