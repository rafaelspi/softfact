package br.edu.uniesp.softfact.infra.stack;

import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.domain.stack.Stack;
import br.edu.uniesp.softfact.domain.stack.UpdateStackService;
import br.edu.uniesp.softfact.infra.mapper.StackEntityMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateStackServiceImpl implements UpdateStackService {

    private final StackRepository repo;
    private final StackEntityMapper entityMapper;

    @Override
    public StackResponse criar(Stack domain) {

        if (repo.existsByNome(domain.getNome())) {
            throw new DataIntegrityViolationException("Nome da Stack já cadastrado: " + domain.getNome());
        }

        StackEntity novaStack = entityMapper.toEntity(domain);
        StackEntity savedEntity = repo.save(novaStack);

        return entityMapper.toResponse(savedEntity);
    }

    @Override
    public StackResponse atualizar(Long id, Stack domain) {

        StackEntity existente = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stack de Tecnologia não encontrada: " + id));

        if (!existente.getNome().equalsIgnoreCase(domain.getNome()) && repo.existsByNome(domain.getNome())) {
            throw new DataIntegrityViolationException("Nome da Stack já cadastrado por outra Stack.");
        }

        existente.setNome(domain.getNome());
        existente.setCategoria(domain.getCategoria());

        return entityMapper.toResponse(existente);
    }


    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Stack de Tecnologia não encontrada: " + id);
        }
        repo.deleteById(id);
    }
}