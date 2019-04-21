package com.flex.dividas.service.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.flex.dividas.domain.Divida;
import com.flex.dividas.service.dto.DividaDTO;

@Mapper(componentModel = "spring", uses = {})
public interface DividaMapper extends EntityMapper<DividaDTO, Divida> {

	Divida toEntity(DividaDTO dto);

	@InheritInverseConfiguration
	DividaDTO toDto(Divida entity);
	
}
