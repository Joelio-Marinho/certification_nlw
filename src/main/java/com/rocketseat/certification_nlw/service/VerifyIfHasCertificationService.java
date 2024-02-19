package com.rocketseat.certification_nlw.service;

import com.rocketseat.certification_nlw.DTO.VerifyCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationService {

    public boolean execute(VerifyCertificationDTO dto){
        if (dto.getEmail().equals()) return true;
        return false;
    }
}
