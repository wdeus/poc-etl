package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.Vaga;

import java.util.List;

public interface VagaRepository {
    List<Vaga> salvar(List<Vaga> vaga);

    boolean existePorId(int idVaga);
}
