package br.edu.uniesp.softfact.boundaries.rest.stack;

import br.edu.uniesp.softfact.application.mappers.StackCreateMapper;
import br.edu.uniesp.softfact.application.mappers.StackUpdateMapper;
import br.edu.uniesp.softfact.application.stack.StackCreateRequest;
import br.edu.uniesp.softfact.application.stack.StackResponse;
import br.edu.uniesp.softfact.application.stack.StackUpdateRequest;
import br.edu.uniesp.softfact.domain.stack.UpdateStackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stacks")
@RequiredArgsConstructor
public class StackCommandController {

    private final UpdateStackService updateStackService;

    private final StackCreateMapper createMapper;
    private final StackUpdateMapper updateMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Indica o código de status HTTP 201
    public StackResponse criar(@RequestBody @Valid StackCreateRequest request) {
        var dominio = createMapper.toDomain(request);
        return updateStackService.criar(dominio);
    }

    @PutMapping("/{id}")
    public StackResponse atualizar(@PathVariable Long id, @RequestBody @Valid StackUpdateRequest request) {
        var dominio = updateMapper.toDomain(request);
        return updateStackService.atualizar(id, dominio);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        updateStackService.excluir(id);
    }
}