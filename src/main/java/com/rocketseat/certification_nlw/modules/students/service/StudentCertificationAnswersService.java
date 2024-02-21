package com.rocketseat.certification_nlw.modules.students.service;

import com.rocketseat.certification_nlw.modules.questions.entities.Question;
import com.rocketseat.certification_nlw.modules.questions.repository.QuestionRepository;
import com.rocketseat.certification_nlw.modules.students.DTO.StudentCertificationAnswerDTO;
import com.rocketseat.certification_nlw.modules.students.DTO.VerifyCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.entities.AnswersCertifications;
import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import com.rocketseat.certification_nlw.modules.students.entities.Students;
import com.rocketseat.certification_nlw.modules.students.repository.CertificationEstudentRepository;
import com.rocketseat.certification_nlw.modules.students.repository.StudantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersService {

    @Autowired
    StudantRepository studantRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private CertificationEstudentRepository certificationEstudentRepository;

    @Autowired
    private VerifyIfHasCertificationService verifyIfHasCertificationService;

    public CertificationStudent execute(StudentCertificationAnswerDTO dto) throws Exception {

        var hasCertification =   this.verifyIfHasCertificationService.execute(new VerifyCertificationDTO(dto.getEmail(), dto.getTechnology()));

        if(hasCertification){
            throw new Exception("Você já tirou sua certificação");
        }
        List<Question> questionEntity = questionRepository.findByTechnology(dto.getTechnology());
        List<AnswersCertifications> answersCertifications = new ArrayList<>();

        AtomicInteger correct = new AtomicInteger();

        dto.getQuestionAnswerDTO().stream()
                .forEach(questionAnswerDTO -> {
                    var questionStream =  questionEntity.stream()
                            .filter(question -> question.getId().equals(questionAnswerDTO.getQuestionID())).findFirst().get();

                    var findCorrectAlternative = questionStream.getAlternatives()
                            .stream().filter(alternatives -> alternatives.isCorrect()).findFirst().get();

                    if (findCorrectAlternative.getId().equals(questionAnswerDTO.getAlternativeID())){
                        correct.incrementAndGet();
                        questionAnswerDTO.setCorrect(true);
                    }else {
                        questionAnswerDTO.setCorrect(false);
                    }
                    var answersCertificationEntity =  AnswersCertifications.builder()
                            .answerID(questionAnswerDTO.getAlternativeID())
                            .questionID(questionAnswerDTO.getQuestionID())
                            .isCorrect(questionAnswerDTO.isCorrect()).build();

                    answersCertifications.add(answersCertificationEntity);
                });

        var student = studantRepository.findByEmail(dto.getEmail());

        UUID studentID;
        if (student.isEmpty()){
            var studentEntity = Students.builder().email(dto.getEmail()).build();
            studentEntity = studantRepository.save(studentEntity);

            studentID = studentEntity.getId();
        }else{
            studentID = student.get().getId();
        }



        CertificationStudent certificationStudent = CertificationStudent.builder()
                .technology(dto.getTechnology())
                .StudentID(studentID)
                .grate(correct.get())
                .build();

        answersCertifications.stream().forEach(answersCertifications1 -> {
                answersCertifications1.setCertificationID(certificationStudent.getId());
                answersCertifications1.setCertificationStudent(certificationStudent);
        });

        certificationStudent.setAnswersCertifications(answersCertifications);
        var certificationCreated =  certificationEstudentRepository.save(certificationStudent);
        return certificationCreated;
    }

}
