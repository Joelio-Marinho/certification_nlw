package com.rocketseat.certification_nlw.modules.students.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "certification")
public class CertificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grate;

    @Column(name =  "student_id")
    private UUID StudentID;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Students studentsEntity;

    @OneToMany
    @JsonManagedReference
    @JoinColumn(name = "answer_certification_id")
    private List<AnswersCertifications> answersCertifications;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
