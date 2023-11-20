package com.example.demo.constants;

		//¦CÁ|
public enum RtnCode {

	SUCCESSFUL(200, "Successful"), //
	PARAM_ERROR(400, "Param Error"), //
	ACCOUNT_EXISTED(400, "Accont existed"), //
	ACCOUNT_NOT_FOUND(404, "account not found"), //
	NOMONEY(400, "nomoney"),//

	;

	private int code;

	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
