package hu.szabo.pixelhunting.team;

import java.util.List;

public interface TeamService {

	List<TeamResponse> getAllTeams();

	TeamResponse saveTeam(TeamRequest request);
}
