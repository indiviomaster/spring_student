package ru.indivio.students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.indivio.students.entites.Student;
import ru.indivio.students.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional <Student> findById(Long id) {
        return studentRepository.findById(id);
    }


    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student edit(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        studentRepository.delete(student.get());
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

}


