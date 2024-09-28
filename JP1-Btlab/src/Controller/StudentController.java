package Controller;

import Entity.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentController {
    private static List<Student> students;
    public StudentController(List<Student> students){
        StudentController.students = students;
    }
    public Optional<Student> getYoungest(){
        Optional<Student> studentYoungest = students.stream()
                .min(Comparator.comparing(Student::getAge));
        return studentYoungest;
    }

    public static List<Student> getByName(String keyword){
        return students.stream()
                .filter(s->s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
