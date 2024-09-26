package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.FatoVaga;
import br.com.poc.etl.llm.core.entity.Periodo;
import br.com.poc.etl.llm.core.entity.ProcessoSeletivo;
import br.com.poc.etl.llm.core.entity.Vaga;

import java.util.List;

public interface FatoVagaRepository {
    List<FatoVaga> salvar(List<FatoVaga> fatoVagas);

    void popularEntidades(List<FatoVaga> fatoVagas, List<ProcessoSeletivo> processoSeletivos,
                          List<Periodo> periodos, List<Vaga> vagas);
}
