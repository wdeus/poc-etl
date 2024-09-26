package br.com.poc.etl.llm.core.repository;

import br.com.poc.etl.llm.core.entity.Feedback;

import java.util.List;

public interface FeedbackRepository {
    List<Feedback> salvar(List<Feedback> feedbacks);

    boolean existePorId(int idFeedback);
}
