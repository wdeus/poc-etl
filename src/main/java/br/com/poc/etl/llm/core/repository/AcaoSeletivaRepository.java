package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.AcaoSeletiva;

import java.util.List;

public interface AcaoSeletivaRepository {
    List<AcaoSeletiva> salvar(List<AcaoSeletiva> acoesSeletivas);

    boolean existePorId(int idAcao);
}
