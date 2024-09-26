package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.Periodo;

import java.util.List;

public interface PeriodoRepository {
    List<Periodo> salvar(List<Periodo> periodos);

    boolean existePorId(int idPeriodo);
}
