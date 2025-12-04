package br.edu.uniesp.softfact.application.projeto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import java.util.Set;


public record ProjetoUpdateRequest(
       @NotBlank String nome,
       @NotBlank String descricao,
       @NotNull @NotEmpty Set<Long> alunosIds,
       @NotNull @NotEmpty Set<Long> stacksIds
) {}



