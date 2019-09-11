package com.jpademo.jpademo.repo;

import com.jpademo.jpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    List<Student> findByCity(String city);
    List<Student> findByNameLike(String name);
    Student findByNameAndId(String name,Integer id);
    List<Student> findByNameOrId(String name, Integer id);
}
