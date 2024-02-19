package com.rocketseat.certification_nlw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswersCertifications {

    private UUID id;
    private UUID certificationID;
    private UUID StudentID;

    private UUID questionID;
    private UUID answerID;

    private boolean isCorrect;

}
