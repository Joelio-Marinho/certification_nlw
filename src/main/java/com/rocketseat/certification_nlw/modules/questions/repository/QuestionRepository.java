package com.rocketseat.certification_nlw.modules.questions.repository;

import com.rocketseat.certification_nlw.modules.questions.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

    List<Question> findByTechnology(String technology);
}
