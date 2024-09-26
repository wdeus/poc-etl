package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.Vaga;
import br.com.poc.etl.llm.core.repository.VagaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaJpaRepository extends JpaRepository<Vaga, Integer>, VagaRepository {

    default List<Vaga> salvar(List<Vaga> vagas){
        return saveAll(vagas);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
