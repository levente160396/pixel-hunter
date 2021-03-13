package hu.szabo.pixelhunting.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.szabo.pixelhunting.user.User;
import lombok.Data;

@Data
@Entity
@Table(name = "TEAM_MEMBER")
public class TeamMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TEAM_MEMBER_TYPE", nullable = false)
	private TeamMemberType teamMemberType;
	
	@Column(name="REC_USER_ID",nullable=true)
	protected String recUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="REC_DATE",nullable=true)
	protected java.util.Date recDate;
	
	@Column(name="MOD_USER_ID",nullable=true)
	protected String modUserId;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_FK")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TEAM_FK")
	private Team team;
	
}
