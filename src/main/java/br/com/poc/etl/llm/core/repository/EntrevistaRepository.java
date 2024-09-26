package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.Entrevista;

import java.util.List;

public interface EntrevistaRepository {
    List<Entrevista> salvar(List<Entrevista> entrevistas);

    boolean existePorId(int idEntrevista);
}
