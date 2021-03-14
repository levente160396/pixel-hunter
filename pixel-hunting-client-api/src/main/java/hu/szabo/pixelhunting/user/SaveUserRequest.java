package hu.szabo.pixelhunting.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SaveUserRequest implements Serializable {

	private static final long serialVersionUID = 3554759374516009841L;

	private Long modifyId;

	@Size(min = 3, max = 50)
	@NotBlank(message = "Name is required!")
	private String username;

	@Size(min = 3, max = 100)
	@NotBlank(message = "First name is required!")
	private String firstName;

	@Size(min = 3, max = 100)
	@NotBlank(message = "Last Name is required!")
	private String lastName;

	@Size(min = 3, max = 100)
	@NotBlank(message = "Email is required!")
	private String email;

	@Size(min = 8)
	@NotBlank(message = "Password is required!")
	private String password;

	private Boolean isActive;

	private Role role;
	
	private Date lastLogin;
}
