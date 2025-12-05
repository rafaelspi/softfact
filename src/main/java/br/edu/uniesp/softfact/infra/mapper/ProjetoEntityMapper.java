package br.edu.uniesp.softfact.infra.mapper;


import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.Projeto;
import br.edu.uniesp.softfact.infra.projeto.ProjetoEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProjetoEntityMapper {


   ProjetoEntity toEntity(Projeto dto);


   ProjetoResponse toResponse(ProjetoEntity entity);
}

