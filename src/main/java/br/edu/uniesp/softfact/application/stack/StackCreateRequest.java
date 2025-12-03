package br.edu.uniesp.softfact.application.stack;

import jakarta.validation.constraints.NotBlank;

public record StackCreateRequest(
        @NotBlank String nome,
        @NotBlank String categoria
) {}
