package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.Entrevista;
import br.com.poc.etl.llm.core.repository.EntrevistaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrevistaJpaRepository extends JpaRepository<Entrevista, Integer>, EntrevistaRepository {

    default List<Entrevista> salvar(List<Entrevista> entrevistas) {
        return saveAll(entrevistas);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
