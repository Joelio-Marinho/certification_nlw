package com.rocketseat.certification_nlw.modules.students.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "answers_certifications_students")
public class AnswersCertifications {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "certification_id")
    private UUID certificationID;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "certification_id",insertable = false, updatable = false)
    private CertificationStudent certificationStudent;

    @Column(name = "Student_id")
    private UUID StudentID;

    @ManyToOne()
    @JoinColumn(name = "Student_id",insertable = false, updatable = false)
    private Students students;

    @Column(name = "question_id")
    private UUID questionID;


    @Column(name = "answer_id")
    private UUID answerID;


    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
