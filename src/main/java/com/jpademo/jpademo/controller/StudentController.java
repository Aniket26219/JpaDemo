package com.jpademo.jpademo.controller;

import com.jpademo.jpademo.model.Student;
import com.jpademo.jpademo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping(value = "/savedata")
    public String saveData(@RequestBody Student student){
        studentRepo.save(student);
        return "Data Saved";
    }
    @GetMapping(value = "/getdatabyid/{id}")
    public Optional<Student> getDataById(@PathVariable Integer id){
        Optional<Student> student=studentRepo.findById(id);
        return student;
    }
    @GetMapping(value = "/getdatabyname/{name}")
    public Student getDataByName(@PathVariable String name){
        Student stud=studentRepo.findByName(name);
        return stud;
    }
    @GetMapping(value = "/getdatabycity/{city}")
    public List<Student> getDataByCity(@PathVariable String city){
        List<Student> list=studentRepo.findByCity(city);
        return list;
    }
    @PutMapping(value = "/updatedata/{id}/{name}/{city}")
    public String updateData(@PathVariable Integer id,@PathVariable String name,@PathVariable String city){
        Optional<Student> student1=studentRepo.findById(id);
        if(student1.isPresent()){
            Student s=student1.get();
            s.setName(name);
            s.setCity(city);
            studentRepo.save(s);
        }
        return "Data Updated";
    }
    @GetMapping(value = "/getbyname/{name}")
    public List<Student> getByName(@PathVariable String name){
        String string="%"+name+"%";
        List<Student> student=studentRepo.findByNameLike(string);
        return student;
    }

    @GetMapping(value = "/getdatabynameandid/{name}/{id}")
    public Student getByNameAndId(@PathVariable String name,@PathVariable Integer id){
        Student student=studentRepo.findByNameAndId(name,id);
        return student;
    }

    @GetMapping(value = "/getbynameorid/{name}/{id}")
    public List<Student> getByNameOrId(@PathVariable String name,@PathVariable Integer id){
        List<Student> studentlist=studentRepo.findByNameOrId(name, id);
        return studentlist;
    }
}
