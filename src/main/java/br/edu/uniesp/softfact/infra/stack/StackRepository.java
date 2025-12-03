package br.edu.uniesp.softfact.infra.stack;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StackRepository extends JpaRepository<StackEntity, Long> {

    boolean existsByNome(String nome);
    Optional<StackEntity> findByNome(String nome);
    Page<StackEntity> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<StackEntity> findByCategoriaContainingIgnoreCase(String categoria, Pageable pageable);

}