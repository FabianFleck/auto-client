package br.com.auto.client.mapper;

import br.com.auto.client.model.entity.ClientEntity;
import br.com.auto.client.model.request.ClientRequestDTO;
import br.com.auto.client.model.request.ClientUpdateRequestDTO;
import br.com.auto.client.model.response.ClientResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientEntity toEntity(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO toDto(ClientEntity client);

    List<ClientResponseDTO> toDtoList(List<ClientEntity> clients);

    @Mapping(target = "id", ignore = true)
    void toDto(ClientUpdateRequestDTO clientRequestDTO, @MappingTarget ClientEntity clientEntity);
}

