package com.rocketseat.certification_nlw.modules.certification.controller;

import com.rocketseat.certification_nlw.modules.certification.service.RankingService;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.repository.CertificationEstudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("'/ranking")
public class RankingController {


    @Autowired
    private RankingService rankingService;

    @GetMapping("/top10")
    public List<CertificationStudent> top10(){
        return this.rankingService.execute();
    }


}
