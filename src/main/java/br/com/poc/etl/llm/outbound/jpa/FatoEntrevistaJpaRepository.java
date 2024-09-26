package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.*;
import br.com.poc.etl.llm.core.repository.FatoEntrevistaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatoEntrevistaJpaRepository extends JpaRepository<FatoEntrevista, Integer>, FatoEntrevistaRepository {

    default List<FatoEntrevista> salvar(List<FatoEntrevista> fatoEntrevistas) {
        return saveAll(fatoEntrevistas);
    }

    default void popularEntidades(List<FatoEntrevista> fatoEntrevistas, List<Entrevista> entrevistas, List<Vaga> vagas,
                                  List<Feedback> feedbacks, List<AcaoSeletiva> acaoSeletivas, List<ParticipanteRH> participanteRHS,
                                  List<Contratacao> contratacoes){
        for(int i=0; i<fatoEntrevistas.size();i++){
            FatoEntrevista fato = fatoEntrevistas.get(i);
            fato.setEntrevista(entrevistas.get(i));
            fato.setVaga(vagas.get(i));
            fato.setFeedback(feedbacks.get(i));
            fato.setAcaoSeletiva(acaoSeletivas.get(i));
            fato.setParticipanteRh(participanteRHS.get(i));
            fato.setContratacao(contratacoes.get(i));
        }

    }
}
