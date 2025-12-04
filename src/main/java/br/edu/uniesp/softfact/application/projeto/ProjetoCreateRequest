package br.edu.uniesp.softfact.application.projeto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


import java.util.Set;


public record ProjetoCreateRequest(
       @NotBlank String nome,
       @NotBlank String descricao,
       @NotEmpty Set<Long> alunosIds,
       @NotEmpty Set<Long> stacksIds
) {}



