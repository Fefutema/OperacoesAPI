package br.com.futema.desafio.view;

public class ResponseView {

	private Long code;
	private String msg;

	public ResponseView() {}

	public ResponseView(Long code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
