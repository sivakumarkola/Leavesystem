package com.example.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.leave.model.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer>{

}
