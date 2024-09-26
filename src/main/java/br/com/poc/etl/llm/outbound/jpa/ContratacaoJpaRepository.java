package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.Contratacao;
import br.com.poc.etl.llm.core.repository.ContratacaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratacaoJpaRepository extends JpaRepository<Contratacao, Integer>, ContratacaoRepository {

    default List<Contratacao> salvar(List<Contratacao> contratacoes) {
        return saveAll(contratacoes);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
