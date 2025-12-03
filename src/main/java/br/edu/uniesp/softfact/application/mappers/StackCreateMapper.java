package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.domain.stack.Stack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackCreateMapper {
    Stack toDomain(StackCreateRequest request);
}
