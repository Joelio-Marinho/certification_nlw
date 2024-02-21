package com.rocketseat.certification_nlw.modules.students.controller;

import com.rocketseat.certification_nlw.modules.students.DTO.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.DTO.VerifyCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.service.StudentCertificationAnswersService;
import com.rocketseat.certification_nlw.modules.students.service.VerifyIfHasCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;

    @Autowired
    private StudentCertificationAnswersService studentCertificationAnswersService;

    @PostMapping ("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyCertificationDTO verifyCertificationDTO){
        var result = verifyIfHasCertificationService.execute(verifyCertificationDTO);
        System.out.println(verifyCertificationDTO);
        return "usuario pode usar a prova";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertificationAnswerDTO dto) throws Exception {
        try{
            var result = this.studentCertificationAnswersService.execute(dto);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
