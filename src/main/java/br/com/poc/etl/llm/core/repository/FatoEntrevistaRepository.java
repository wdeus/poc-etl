package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.*;

import java.util.List;

public interface FatoEntrevistaRepository {
    List<FatoEntrevista> salvar(List<FatoEntrevista> fatoEntrevistas);

    void popularEntidades(List<FatoEntrevista> fatoEntrevistas, List<Entrevista> entrevistas, List<Vaga> vagas,
                                  List<Feedback> feedbacks, List<AcaoSeletiva> acaoSeletivas, List<ParticipanteRH> participanteRHS,
                                  List<Contratacao> contratacoes);
}
