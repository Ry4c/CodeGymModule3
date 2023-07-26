package service;

import model.Student;
import service.IService.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService<Student> {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        this.students.add(new Student(1, 20,"Thục", "https://didongviet.vn/dchannel/wp-content/uploads/2023/05/meme-didongviet-13.jpg"));
        this.students.add(new Student(2, 22,"Linh Lee", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpAmyN0B9lTXz9qEuZ84mwYAOvQz4yYTXFkw&usqp=CAU"));
    }

    @Override
    public void add(Student student) {
        this.students.add(student);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < this.students.size(); i++) {
            if(id == students.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void delete(int id) {
        int index = this.findById(id);
        this.students.remove(index);
    }

    @Override
    public List<Student> findAll() {
        return this.students;
    }

    @Override
    public void edit(int id, Student student) {
        int index = this.findById(id);
        this.students.set(index, student);
    }

    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student s : this.students) {
            if (s.getName().toLowerCase().contains(name.toLowerCase()))
                students.add(s);
        }
        return students;
    }
}
