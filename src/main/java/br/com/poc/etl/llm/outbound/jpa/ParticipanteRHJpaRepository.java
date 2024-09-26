package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.ParticipanteRH;
import br.com.poc.etl.llm.core.repository.ParticipanteRHRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipanteRHJpaRepository extends JpaRepository<ParticipanteRH, Integer>, ParticipanteRHRepository {

    default List<ParticipanteRH> salvar(List<ParticipanteRH> participantesRH) {
        return saveAll(participantesRH);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
