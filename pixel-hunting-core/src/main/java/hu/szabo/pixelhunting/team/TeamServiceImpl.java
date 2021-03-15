package hu.szabo.pixelhunting.team;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szabo.pixelhunting.user.User;
import hu.szabo.pixelhunting.user.UserRepository;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Override
	public List<TeamResponse> getAllTeams() {
		return TeamMapper.INSTANCE.teamsToTeamResponse(teamRepository.findAll());
	}

	@Override
	public TeamResponse saveTeam(TeamRequest request) {
		Team saveTeam = teamRepository.save(TeamMapper.INSTANCE.teamRequestToTeam(request));

		if (null == request.getModiflyId() && null != request.getRecUserId()) {
			Optional<User> findById = userRepository.findById(request.getRecUserId());

			TeamMember teamMember = new TeamMember();
			teamMember.setTeamMemberType(TeamMemberType.OWNER);
			teamMember.setUser(findById.get());
			teamMember.setTeam(saveTeam);

			teamMemberRepository.save(teamMember);
		}

		return TeamMapper.INSTANCE.teamToTeamResponse(saveTeam);
	}

}
