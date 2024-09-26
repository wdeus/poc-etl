package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.ProcessoSeletivo;
import br.com.poc.etl.llm.core.repository.ProcessoSeletivoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessoSeletivoJpaRepository extends JpaRepository<ProcessoSeletivo, Integer>, ProcessoSeletivoRepository {

    default List<ProcessoSeletivo> salvar(List<ProcessoSeletivo> processos) {
        return saveAll(processos);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
