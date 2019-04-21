package com.flex.dividas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flex.dividas.domain.Divida;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

	Divida findByUsuarioId(Long usuarioId);

}
