package br.edu.uniesp.softfact.infra.mapper;

import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.Stack;
import br.edu.uniesp.softfact.infra.stack.StackEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StackEntityMapper {

    StackEntity toEntity(Stack domain);
    Stack toDomain(StackEntity entity);
    Stack toDomain(StackUpdateRequest request);
    StackResponse toResponse(StackEntity entity);
}