package com.rocketseat.certification_nlw.modules.questions.controller;

import com.rocketseat.certification_nlw.modules.questions.DTO.AlternativeResultDTO;
import com.rocketseat.certification_nlw.modules.questions.DTO.QuestionsResultetDTO;
import com.rocketseat.certification_nlw.modules.questions.entities.Alternatives;
import com.rocketseat.certification_nlw.modules.questions.entities.Question;
import com.rocketseat.certification_nlw.modules.questions.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    @GetMapping("/technology/{technology}")
    public List<QuestionsResultetDTO> findByTechnology(@PathVariable String technology){
        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question))
                .collect(Collectors.toList());
        return  toMap ;
    }


    static QuestionsResultetDTO mapQuestionToDTO(Question question){
       var questionsResultetDTO = QuestionsResultetDTO.builder()
               .id(question.getId())
               .technology(question.getTechnology())
               .description(question.getDescription()).build();

       List<AlternativeResultDTO> alternativeResultDTOS = question.getAlternatives()
               .stream().map(alternatives -> mapAlternativeDTO(alternatives))
               .collect(Collectors.toList());

        questionsResultetDTO.setAlternatives(alternativeResultDTOS);
        return questionsResultetDTO;
    }

    static AlternativeResultDTO mapAlternativeDTO(Alternatives alternativeResult){
        return AlternativeResultDTO.builder()
                .id(alternativeResult.getId())
                .description(alternativeResult.getDescription()).build();

    }
}
