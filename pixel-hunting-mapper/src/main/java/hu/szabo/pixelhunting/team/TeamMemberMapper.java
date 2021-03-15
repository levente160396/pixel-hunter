package hu.szabo.pixelhunting.team;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMemberMapper {

	TeamMemberMapper INSTANCE = Mappers.getMapper(TeamMemberMapper.class);
	
	TeamMemberResponse teamMemberToTeamMemberResponse(TeamMember teamMember);
	
	List<TeamMemberResponse> teamMembersToTeamMemberResponse(List<TeamMember> teamMember);
}
