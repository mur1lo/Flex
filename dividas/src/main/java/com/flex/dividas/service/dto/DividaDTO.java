package com.flex.dividas.service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Todos os detalhes sobre a Dívida. ")
public class DividaDTO {

	@ApiModelProperty(notes = "Identificador da Dívida")
	private Long id;

	@ApiModelProperty(notes = "Identificador da Usuário")
	@NotNull(message = "Código é obrigatório!")
	private Long usuarioId;

	@ApiModelProperty(notes = "Motivo da Dívida")
	@NotNull(message = "Campo Motivo é obrigatório!")
	@NotEmpty(message = "Campo motivo não pode ser vazio!")
	@Size(message = "Tamanho maximo do motivo é de {max}!", max = 100)
	private String motivo;

	@ApiModelProperty(notes = "Data da Dívida")
	@NotNull(message = "Campo Data é obrigatório!")
	private LocalDate data;

	@ApiModelProperty(notes = "Valor da Dívida")
	@NotNull(message = "Campo Valor é obrigatório!")
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
