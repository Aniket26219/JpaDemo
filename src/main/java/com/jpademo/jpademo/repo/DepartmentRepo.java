package com.jpademo.jpademo.repo;

import com.jpademo.jpademo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
