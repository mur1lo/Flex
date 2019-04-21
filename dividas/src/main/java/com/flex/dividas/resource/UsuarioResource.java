package com.flex.dividas.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flex.dividas.service.UsuarioService;
import com.flex.dividas.service.dto.UsuarioDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Api para cadastrar dívidas do usuário")
@RestController
@RequestMapping(value = "/v1/api/usuario")
public class UsuarioResource {

	private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(value = "Busca todos os usuários", response = UsuarioDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findUsuarios() {
		log.debug("REST request para buscar os usuarios");
		return ResponseEntity.ok(usuarioService.buscarTodosUsuario());
	}

	@ApiOperation(value = "Salva uma Dívida do Usuário", response = UsuarioDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping
	public ResponseEntity<UsuarioDTO> saveUser(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		log.debug("REST request para salvar o usuario : {}", usuarioDTO);
		UsuarioDTO response = this.usuarioService.salvar(usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(response, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Atualiza uma Dívida do Usuário", response = UsuarioDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PutMapping
	public ResponseEntity<UsuarioDTO> atualizar(@RequestBody UsuarioDTO usuarioDTO) {
		log.debug("REST request para atualizar o usuario : {}", usuarioDTO);
		UsuarioDTO response = this.usuarioService.atualizar(usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
		this.usuarioService.deletarDivida(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
