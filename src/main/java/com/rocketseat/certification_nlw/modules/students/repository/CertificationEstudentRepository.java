package com.rocketseat.certification_nlw.modules.students.repository;

import com.rocketseat.certification_nlw.modules.students.entities.CertificationStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationEstudentRepository extends JpaRepository<CertificationStudent, UUID> {


    @Query( "SELECT c FROM certification c INNER JOIN c.studentsEntity STD WHERE STD.email = :email AND c.technology = :technology")
    List<CertificationStudent> findByStudentEmailAndTechnology(String email, String technology);
}
