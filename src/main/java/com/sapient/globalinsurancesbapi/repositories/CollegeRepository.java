package com.sapient.globalinsurancesbapi.repositories;

import com.sapient.globalinsurancesbapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<Student, Long> {
}
