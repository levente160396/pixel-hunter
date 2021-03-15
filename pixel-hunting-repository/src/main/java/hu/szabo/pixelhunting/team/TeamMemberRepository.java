package hu.szabo.pixelhunting.team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

	@Query("SELECT tm from TeamMember tm where tm.team.id=:teamId")
	List<TeamMember> getTeamMemberByTeamId(@Param("teamId")Long teamId);
}
