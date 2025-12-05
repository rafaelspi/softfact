package br.edu.uniesp.softfact.infra.projeto;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Collection;


@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {


   Page<ProjetoEntity> findByNomeContainingIgnoreCase(String nome, Pageable pageable);


   Page<ProjetoEntity> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);


   Page<ProjetoEntity> findDistinctByStacks_NomeInIgnoreCase(Collection<String> nomesStacks, Pageable pageable);
}

