package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class StudentManage {
    private List<Student> students;

    public StudentManage() {
        students = new ArrayList<Student>();
        students.add(new Student(1,"ten1",21,"dia chi 1"));
        students.add(new Student(1,"ten2",22,"dia chi 2"));
        students.add(new Student(1,"ten3",23,"dia chi 3"));
        students.add(new Student(1,"ten4",24,"dia chi 4"));
        students.add(new Student(1,"ten5",25,"dia chi 5"));
    }
    public List<Student> getStudents(){
        return this.students;
    }
}
