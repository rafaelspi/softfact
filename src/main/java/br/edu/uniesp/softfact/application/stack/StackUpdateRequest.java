package br.edu.uniesp.softfact.application.stack;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StackUpdateRequest(
        @NotNull Long id,
        @NotBlank String nome,
        String categoria
) {}
