package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.ParticipanteRH;

import java.util.List;

public interface ParticipanteRHRepository {
    List<ParticipanteRH> salvar(List<ParticipanteRH> participantesRH);

    boolean existePorId(int idParticipanteRH);
}
