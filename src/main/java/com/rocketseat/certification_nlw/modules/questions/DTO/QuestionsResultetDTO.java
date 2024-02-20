package com.rocketseat.certification_nlw.modules.questions.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionsResultetDTO {

    private UUID id;
    private String technology;
    private String description;
    private List<AlternativeResultDTO> alternatives;

}
