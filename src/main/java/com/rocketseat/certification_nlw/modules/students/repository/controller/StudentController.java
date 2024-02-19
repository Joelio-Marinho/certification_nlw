package com.rocketseat.certification_nlw.modules.students.repository.controller;

import com.rocketseat.certification_nlw.modules.students.DTO.VerifyCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.service.VerifyIfHasCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;

    @PostMapping ("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyCertificationDTO verifyCertificationDTO){
        var result = verifyIfHasCertificationService.execute(verifyCertificationDTO);
        System.out.println(verifyCertificationDTO);
        return "usuario pode usar a prova";
    }
}
