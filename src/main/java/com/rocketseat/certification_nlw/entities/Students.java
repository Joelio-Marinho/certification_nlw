package com.rocketseat.certification_nlw.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    private UUID id;
    private String email;
    private List<CertificationStudent> certificationStudent;
}
