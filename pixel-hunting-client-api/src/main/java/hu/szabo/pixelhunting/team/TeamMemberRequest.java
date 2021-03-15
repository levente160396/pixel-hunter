package hu.szabo.pixelhunting.team;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TeamMemberRequest implements Serializable {
	
	private static final long serialVersionUID = 278409278441164419L;
	
	private Long teamMemberId;
	
	@NotBlank(message = "teamMember cannot be null!")
	private TeamMemberType teamMemberType;
	
	@NotBlank(message = "Userid cannot be null!")
	private Long userId;
	
	@NotBlank(message = "TeamId cannot be null!")
	private Long teamId;
}
