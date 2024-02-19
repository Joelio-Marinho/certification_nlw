package com.rocketseat.certification_nlw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudent {

    private UUID StudentID;
    private UUID id;
    private String technology;
    private int grate;

    private List<AnswersCertifications> answersCertifications;


}
