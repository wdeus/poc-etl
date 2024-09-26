package br.com.poc.etl.llm.outbound.jpa;

import br.com.poc.etl.llm.core.entity.Feedback;
import br.com.poc.etl.llm.core.repository.FeedbackRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackJpaRepository extends JpaRepository<Feedback, Integer>, FeedbackRepository {

    default List<Feedback> salvar(List<Feedback> feedbacks) {
        return saveAll(feedbacks);
    }

    default boolean existePorId(int id){
        return existsById(id);
    }
}
