package com.flex.dividas.service;

import java.util.List;

import com.flex.dividas.service.dto.UsuarioDTO;

public interface UsuarioService {

	List<UsuarioDTO> buscarTodosUsuario();

	UsuarioDTO salvar(UsuarioDTO usuarioDTO);

	UsuarioDTO atualizar(UsuarioDTO usuarioDTO);

	void deletarDivida(Long id);
}
