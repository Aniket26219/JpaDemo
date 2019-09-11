package com.jpademo.jpademo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    private Integer id;
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
