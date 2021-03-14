package hu.szabo.pixelhunting.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "TEAM")
public class Team {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 3, max = 50)
	@Column(unique = true, nullable = false, name = "NAME")
	private String name;
	
	@Column(name="REC_USER_ID",nullable=true)
	protected String recUserId;
	
	@Size(max = 500)
	@Column(nullable = false, name = "DESCRIPTION")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REC_DATE",nullable=true)
	private java.util.Date recDate;
	
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name="MOD_DATE",nullable=true)
	protected java.util.Date modDate;
	
	@PrePersist
	protected void onCreate() {
		recDate = new java.util.Date();
		modDate = recDate;
	}
	
	@PreUpdate
	protected void onUpdate() {
		modDate = new java.util.Date();
	}
}
