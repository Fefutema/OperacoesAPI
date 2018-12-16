package br.com.futema.desafio.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long code;

	public BusinessException(Long code, String msg) {
		super(msg);
	}

	public Long getCode() {
		return code;
	}

}
