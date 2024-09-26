package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;

import java.util.List;

public interface FormatadorRepository {

    <T> T executar(String json, Class<T> entidadeClass);

    List<String> extrairJsonObjects(String input);
}
