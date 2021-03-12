package hu.szabo.pixelhunting.server;

import java.io.Serializable;

public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 2474567940988060001L;

	private Boolean success;

	private String message;

	public BaseResponse() {
	}

	public BaseResponse(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BaseResponse [success=" + success + ", message=" + message + "]";
	}
}
