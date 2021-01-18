package ru.indivio.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.indivio.students.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
