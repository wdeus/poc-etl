package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.AcaoSeletiva;
import br.com.poc.etl.llm.core.repository.AcaoSeletivaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoSeletivaJpaRepository extends JpaRepository<AcaoSeletiva, Integer>, AcaoSeletivaRepository {

    default List<AcaoSeletiva> salvar(List<AcaoSeletiva> acoesSeletivas) {
        return saveAll(acoesSeletivas);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
