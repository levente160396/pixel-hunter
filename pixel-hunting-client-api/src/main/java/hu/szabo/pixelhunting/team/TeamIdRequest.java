package hu.szabo.pixelhunting.team;

import java.io.Serializable;

import lombok.Data;

@Data
public class TeamIdRequest implements Serializable {

	private static final long serialVersionUID = -1523345255694511731L;
	
	private Long teamId;
}
