package com.org.helloworld.bs;

import com.org.helloworld.dto.StudentDTO;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class StudentBS {

    private static final List<StudentDTO> STUDENTS = new ArrayList<>();

    public List<StudentDTO> getStudentsList(){
        return STUDENTS;
    }

    public void addStudent(StudentDTO student){
        System.out.println("new");
        STUDENTS.add(student);
    }

    public StudentDTO getStudent(int id){
        for(StudentDTO student : STUDENTS){
            if(student.getId() == id) return student;
        }
        return null;
    }

}
