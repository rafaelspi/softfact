package br.edu.uniesp.softfact.domain.projeto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Projeto {


   private Long id;
   private String nome;
   private String descricao;


   private Set<Long> alunosIds;
   private Set<Long> stacksIds;
}

