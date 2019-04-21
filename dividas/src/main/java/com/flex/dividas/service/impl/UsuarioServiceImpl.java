package com.flex.dividas.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flex.dividas.domain.Divida;
import com.flex.dividas.repository.DividaRepository;
import com.flex.dividas.service.UsuarioService;
import com.flex.dividas.service.dto.DividaDTO;
import com.flex.dividas.service.dto.UsuarioDTO;
import com.flex.dividas.service.mapper.DividaMapper;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Value("${app.user}")
	private String appUser;

	@Autowired
	private DividaMapper dividaMapper;

	@Autowired
	private DividaRepository dividaRepository;

	@Override
	public List<UsuarioDTO> buscarTodosUsuario() {
		RestTemplate restTemplate = new RestTemplate();
		UsuarioDTO[] quote = restTemplate.getForObject(appUser, UsuarioDTO[].class);
		List<UsuarioDTO> listaPesquisa = (List) Arrays.asList(quote);
		listaPesquisa.forEach((usuario) -> {
			DividaDTO dividaDTO = this.dividaMapper.toDto(this.dividaRepository.findByUsuarioId(usuario.getId()));
			usuario.setDivida(dividaDTO);
		});
		return listaPesquisa;
	}

	@Override
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
		DividaDTO dividaDTO = usuarioDTO.getDivida();
		Divida divida = this.dividaMapper.toEntity(dividaDTO);
		divida = this.dividaRepository.save(divida);
		dividaDTO = this.dividaMapper.toDto(divida);
		usuarioDTO.setDivida(dividaDTO);

		return usuarioDTO;
	}

	@Override
	public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {
		return this.salvar(usuarioDTO);
	}

	@Override
	public void deletarDivida(Long id) {
		this.dividaRepository.deleteById(id);
	}

}
