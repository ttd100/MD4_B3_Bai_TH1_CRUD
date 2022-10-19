package rikkei.academy.service;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Student;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceIMPL implements IStudentService{
    public static List<Student> studentList = new ArrayList<>();
    private static int lastId = 0;
    static {
        studentList.add(new Student(1,"ha",20));
        lastId++;
        studentList.add(new Student(2,"hung",20));
        lastId++;
        studentList.add(new Student(3,"phu",20));
        lastId++;
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        lastId++;
        student.setId(lastId);
        studentList.add(student);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
            }
        }
    }

    @Override
    public void update(Student student) {
        studentList.add(student.getId(),student);
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }
}
