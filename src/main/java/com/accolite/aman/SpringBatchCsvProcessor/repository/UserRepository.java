package com.accolite.aman.SpringBatchCsvProcessor.repository;

import com.accolite.aman.SpringBatchCsvProcessor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
