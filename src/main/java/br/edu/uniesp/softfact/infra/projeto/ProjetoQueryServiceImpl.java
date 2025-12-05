package br.edu.uniesp.softfact.infra.projeto;


import br.edu.uniesp.softfact.application.projeto.ProjetoAlunoResumo;
import br.edu.uniesp.softfact.application.projeto.ProjetoResponse;
import br.edu.uniesp.softfact.domain.projeto.ProjetoQueryService;
import br.edu.uniesp.softfact.infra.aluno.AlunoEntity;
import br.edu.uniesp.softfact.zo.old.stack.dto.StackResumo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class ProjetoQueryServiceImpl implements ProjetoQueryService {


   private final ProjetoRepository repo;


   @Transactional(readOnly = true)
   @Override
   public ProjetoResponse buscarPorId(Long id) {
       return repo.findById(id).map(this::toResponse)
               .orElseThrow(() -> new EntityNotFoundException("Projeto.java não encontrado: " + id));
   }


   @Transactional(readOnly = true)
   @Override
   public Page<ProjetoResponse> listar(String termo, Pageable pageable) {
       Page<ProjetoEntity> page;
       if (termo == null || termo.isBlank()) {
           page = repo.findAll(pageable);
       } else {
           ExampleMatcher matcher = ExampleMatcher.matchingAny()
                   .withIgnoreNullValues()
                   .withMatcher("nome", m -> m.contains().ignoreCase())
                   .withMatcher("descricao", m -> m.contains().ignoreCase());
           ProjetoEntity probe = new ProjetoEntity();
           probe.setNome(termo);
           probe.setDescricao(termo);
           page = repo.findAll(Example.of(probe, matcher), pageable);
       }
       return page.map(this::toResponse);
   }


   private ProjetoResponse toResponse(ProjetoEntity p) {
       return new ProjetoResponse(
               p.getId(),
               p.getNome(),
               p.getDescricao(),
               p.getAlunos().stream()
                       .map(this::toProjetoAlunoResumo)
                       .collect(Collectors.toSet()),
               p.getStacks().stream()
                       .map(s -> new StackResumo(s.getId(), s.getNome(), s.getCategoria()))
                       .collect(Collectors.toSet())
       );
   }


   private ProjetoAlunoResumo toProjetoAlunoResumo(AlunoEntity a) {
       return new ProjetoAlunoResumo(
               a.getId(),
               a.getNome(),
               a.getMatricula()
       );
   }
}
