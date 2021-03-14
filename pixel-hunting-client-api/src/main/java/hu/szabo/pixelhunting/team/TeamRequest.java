package hu.szabo.pixelhunting.team;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TeamRequest implements Serializable{
	
	private static final long serialVersionUID = -3930258097409791610L;

	private Long modiflyId;
	
	@Size(min = 3, max = 50)
	@NotBlank(message = "Name is required!")
	private String name;
	
	@Size(max = 500)
	private String description;
	
	private String recUserId;
	

}
