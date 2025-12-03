package br.edu.uniesp.softfact.domain.stack;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stack {

    private Long id;
    private String nome;
    private String categoria;
}