package ru.indivio.students.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.indivio.students.entites.Student;
import ru.indivio.students.services.StudentServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {
    private StudentServiceImpl studentService;

    @Autowired
    public void setUsrService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    //private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("")
    public String showAll(Model model) {
        List<Student> students = (List< Student>) studentService.findAll();
        System.out.println(students);
        model.addAttribute("students", students);
        return "students-page";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable(name = "id") Long id) {
        System.out.println("*******ID ***"+id);
        Optional<Student> st = studentService.findById(id);
        Student student;
        if(!st.isPresent()){
            student = new Student();
            student.setId(0L);
        }else{
            student = st.get();
        }
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/edit")
    public String processProductAddForm(@ModelAttribute("student") Student student, Model model) {
        studentService.save(student);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model,@PathVariable(name = "id") Long id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
