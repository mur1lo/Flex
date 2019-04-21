package com.flex.dividas.service.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Todos os detalhes sobre a Usuário. ")
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Identificador do Usuário")
	@NotNull(message = "Código do Usuário é obrigatório!")
	private Long id;

	@ApiModelProperty(notes = "Nome do Usuário")
	@NotEmpty(message = "Nome não pode ser vazio!")
	@NotNull(message = "Nome do usuário é obrigatório!")
	@Size(message = "Tamanho máximo do Nome é de {max}", max = 200)
	private String name;

	@ApiModelProperty(notes = "Email do Usuário")
	@NotEmpty(message = "Email não pode ser vazio!")
	@NotNull(message = "Email do usuário é obrigatório!")
	@Size(message = "Tamanho máximo do Email é de {max}", max = 50)
	private String email;

	@ApiModelProperty(notes = "Dívida do Usuário")
	@Valid
	private DividaDTO divida;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DividaDTO getDivida() {
		return divida;
	}

	public void setDivida(DividaDTO divida) {
		this.divida = divida;
	}

	public boolean isPossuiDivida() {
		return this.divida != null ? true : false;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", name=" + name + ", email=" + email + ", divida=" + divida + "]";
	}

}
