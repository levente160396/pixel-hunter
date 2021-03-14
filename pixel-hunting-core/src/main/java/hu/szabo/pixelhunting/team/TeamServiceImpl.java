package hu.szabo.pixelhunting.team;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public List<TeamResponse> getAllTeams() {
		return TeamMapper.INSTANCE.teamsToTeamResponse(teamRepository.findAll());
	}

	@Override
	public TeamResponse saveTeam(TeamRequest request) {
		return TeamMapper.INSTANCE.teamToTeamResponse(teamRepository.save(TeamMapper.INSTANCE.teamRequestToTeam(request)));
	}

}
