package com.rocketseat.certification_nlw.modules.certification.service;

import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.repository.CertificationEstudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private CertificationEstudentRepository certificationEstudentRepository;

    public List<CertificationStudent> execute(){
        return this.certificationEstudentRepository.findTop10ByOrderByGrateDesc();
    }
}
