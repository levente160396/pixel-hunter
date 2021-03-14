package hu.szabo.pixelhunting.team;

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
public class TeamResponse extends BaseResponse implements Serializable {

	private static final long serialVersionUID = 5358095748564222665L;
	
	private Long id;
	
	private String name;
	
	private String recUserId;
	
	private String description;
	
	private Date recDate;
	
	private Date modDate;

	public TeamResponse(boolean success, String errorMessage) {
		super(success, errorMessage);
	}
}
