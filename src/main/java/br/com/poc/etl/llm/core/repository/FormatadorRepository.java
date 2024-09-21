package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;

import java.util.List;

public interface FormatadorRepository {

    MapeamentoDTO executar(String json);

    List<String> extrairJsonObjects(String input);
}
