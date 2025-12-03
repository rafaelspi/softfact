package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.domain.stack.StackQueryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class StackQueryServiceImpl implements StackQueryService {

    private final StackRepository repo;

    @Transactional(readOnly = true)
    @Override
    public StackResponse buscarPorId(Long id) {
        return repo.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Stack de Tecnologia não encontrada: " + id));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<StackResponse> listar(String termo, Pageable pageable) {
        Page<StackEntity> page;

        if (termo == null || termo.isBlank()) {
            page = repo.findAll(pageable);
        } else {
            ExampleMatcher matcher = ExampleMatcher.matchingAny()
                    .withIgnoreNullValues()
                    .withMatcher("nome", m -> m.contains().ignoreCase())
                    .withMatcher("categoria", m -> m.contains().ignoreCase());

            StackEntity probe = new StackEntity();
            probe.setNome(termo);
            probe.setCategoria(termo);

            page = repo.findAll(Example.of(probe, matcher), pageable);
        }

        return page.map(this::toResponse);
    }

    private StackResponse toResponse(StackEntity s) {
        return new StackResponse(
                s.getId(),
                s.getNome(),
                s.getCategoria()
        );
    }
}
