package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.Periodo;
import br.com.poc.etl.llm.core.repository.PeriodoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodoJpaRepository extends JpaRepository<Periodo, Integer>, PeriodoRepository {

    default List<Periodo> salvar(List<Periodo> periodos) {
        return saveAll(periodos);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
