package com.rocketseat.certification_nlw.modules.students.service;

import com.rocketseat.certification_nlw.modules.students.DTO.VerifyCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.repository.CertificationEstudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationService {

    @Autowired
    private CertificationEstudentRepository certificationEstudentRepository;
    public boolean execute(VerifyCertificationDTO dto){
        var result = this.certificationEstudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
}
