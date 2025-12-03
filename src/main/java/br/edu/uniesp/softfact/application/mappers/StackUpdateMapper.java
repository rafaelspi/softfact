package br.edu.uniesp.softfact.application.mappers;

import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.Stack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StackUpdateMapper {
    Stack toDomain(StackUpdateRequest request);
}
