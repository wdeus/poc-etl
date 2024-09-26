package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.ProcessoSeletivo;

import java.util.List;

public interface ProcessoSeletivoRepository {
    List<ProcessoSeletivo> salvar(List<ProcessoSeletivo> processosSeletivos);

    boolean existePorId(int idProcessoSeletivo);
}
