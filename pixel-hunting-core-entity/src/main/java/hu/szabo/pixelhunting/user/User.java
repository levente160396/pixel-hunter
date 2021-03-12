package hu.szabo.pixelhunting.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, name = "USERNAME")
	private String username;

	@Size(min = 1, max = 50)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(min = 1, max = 50)
	@Column(name = "LAST_NAME")
	private String lastName;

	@Size(min = 1, max = 50)
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@Column(nullable = false, name = "ROLE")
	@Enumerated(EnumType.STRING)
	Role role;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "dd.MM.yyyy HH:mm")
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;

}
