package hu.szabo.pixelhunting.user;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SaveUserRequest implements Serializable {

	private static final long serialVersionUID = 3554759374516009841L;

	private Long modifyId;

	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Boolean isActive;

	private Role role;
	
	private Date lastLogin;
}
