package hu.szabo.pixelhunting.user;

import java.io.Serializable;
import java.util.Date;

import hu.szabo.pixelhunting.utils.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends BaseResponse implements Serializable {

	private static final long serialVersionUID = -671677396154815061L;

	private Long id;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private Boolean isActive;

	private Role role;
	
	private Date lastLogin;
	
	public UserResponse(boolean success, String errorMessage) {
		super(success, errorMessage);
	}
}
