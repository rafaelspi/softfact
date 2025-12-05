package br.edu.uniesp.softfact.domain.projeto;


import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProjetoQueryService {
   ProjetoResponse buscarPorId(Long id);
   Page<ProjetoResponse> listar(String termo, Pageable pageable);
}

