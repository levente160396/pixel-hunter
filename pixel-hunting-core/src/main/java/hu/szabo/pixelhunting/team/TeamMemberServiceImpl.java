package hu.szabo.pixelhunting.team;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szabo.pixelhunting.user.UserMapper;
import hu.szabo.pixelhunting.user.UserRepository;

@Service
@Transactional
public class TeamMemberServiceImpl implements TeamMemberService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TeamMemberRepository teamMemberRepository;
	
	@Override
	public TeamMemberResponse addTeamMemberToTeam(TeamMemberRequest request) {
		TeamMember teamMember = new TeamMember();
		teamMember.setTeam(teamRepository.findById(request.getTeamId()).get());
		teamMember.setUser(userRepository.findById(request.getUserId()).get());
		teamMember.setTeamMemberType(request.getTeamMemberType());
		
		return TeamMemberMapper.INSTANCE.teamMemberToTeamMemberResponse(teamMemberRepository.save(teamMember));
	}

	@Override
	public void deleteTeamMemberFromTeam(Long teamMemberId) {
		teamMemberRepository.deleteById(teamMemberId);
	}

	@Override
	public List<TeamMemberResponse> getTeamMemberByTeamId(Long teamId) {
		
		return TeamMemberMapper.INSTANCE.teamMembersToTeamMemberResponse(teamMemberRepository.getTeamMemberByTeamId(teamId));
	}

}
