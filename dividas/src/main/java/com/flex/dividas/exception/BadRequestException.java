package com.flex.dividas.exception;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String mensagemUsuario;
	private final String mensagemDesenvolvedor;

	public BadRequestException(String mensagemDesenvolvedor, String mensagemUsuario) {
		super(mensagemDesenvolvedor);
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
}