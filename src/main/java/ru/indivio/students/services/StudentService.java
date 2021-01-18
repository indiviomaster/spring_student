package ru.indivio.students.services;

import ru.indivio.students.entites.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService  {

    List<Student> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    Student saveOrUpdate(Student student);
    Student edit(Student student);
    void delete(Student student);
    void delete(Long id);
    Student create(Student student);
    //void add(String name, int age);
}
