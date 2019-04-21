package com.flex.dividas.exception;

public class NegocioException extends BadRequestException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String mensagemDesenvolvedor, String mensagemUsuario) {
		super(mensagemDesenvolvedor, mensagemUsuario);
	}
}
