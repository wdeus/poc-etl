package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.Contratacao;

import java.util.List;

public interface ContratacaoRepository {
    List<Contratacao> salvar(List<Contratacao> contratacoes);

    boolean existePorId(int idContratacao);
}
