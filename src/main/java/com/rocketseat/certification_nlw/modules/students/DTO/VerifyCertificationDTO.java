package com.rocketseat.certification_nlw.modules.students.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyCertificationDTO {

    private String email;
    private String technology;

}
