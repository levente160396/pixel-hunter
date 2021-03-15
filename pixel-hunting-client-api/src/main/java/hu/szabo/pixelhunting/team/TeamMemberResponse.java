package hu.szabo.pixelhunting.team;

import java.io.Serializable;

import hu.szabo.pixelhunting.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class TeamMemberResponse extends BaseResponse implements Serializable {

	private static final long serialVersionUID = -5392797708941962867L;
	
	private Long id;
	
	private TeamMemberType teamMemberType;
	
	private Long userId;
	
	private Long teamId;
	
	public TeamMemberResponse(boolean success, String errorMessage) {
		super(success, errorMessage);
	}
}
