package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.dto.MapeamentoDTO;

public interface MapeamentoRepository {

    void popularEntidades(String mapeamentoDTO);
}
