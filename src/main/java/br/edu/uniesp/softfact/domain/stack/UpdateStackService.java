package br.edu.uniesp.softfact.domain.stack;

import br.edu.uniesp.softfact.application.stack.StackResponse;

public interface UpdateStackService {
    StackResponse criar(br.edu.uniesp.softfact.domain.stack.Stack domain);
    StackResponse atualizar(Long id, br.edu.uniesp.softfact.domain.stack.Stack domain);
    void excluir(Long id);
}