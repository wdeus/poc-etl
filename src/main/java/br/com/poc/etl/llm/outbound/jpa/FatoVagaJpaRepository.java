package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.*;
import br.com.poc.etl.llm.core.repository.FatoVagaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FatoVagaJpaRepository extends JpaRepository<FatoVaga, Integer>, FatoVagaRepository {
    default List<FatoVaga> salvar(List<FatoVaga> fatoVagas) {
        return saveAll(fatoVagas);
    }

    default void popularEntidades(List<FatoVaga> fatoVagas, List<ProcessoSeletivo> processoSeletivos, List<Periodo> periodos,
                                  List<Vaga> vagas){
        for(int i=0; i<fatoVagas.size();i++){
            FatoVaga fato = fatoVagas.get(i);
            fato.setProcessoSeletivo(processoSeletivos.get(i));
            fato.setPeriodo(periodos.get(i));
            fato.setVaga(vagas.get(i));
        }

    }
}
