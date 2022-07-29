package com.sapient.globalinsurancesbapi.repositories;

import com.sapient.globalinsurancesbapi.models.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<College,Long> {
}
