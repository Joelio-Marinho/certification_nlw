package com.rocketseat.certification_nlw.modules.students.repository;

import com.rocketseat.certification_nlw.modules.students.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudantRepository extends JpaRepository<Students, UUID> {

    public Optional<Students> findByEmail(String email);
}
