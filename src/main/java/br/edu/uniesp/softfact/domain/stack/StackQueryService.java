package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.application.stack.StackResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StackQueryService {

    StackResponse buscarPorId(Long id);
    Page<StackResponse> listar(String termo, Pageable pageable);
}