package com.org.helloworld.server;

import com.org.helloworld.dto.StudentDTO;

import java.util.List;

public interface IWSS {

    String sayHello();
    boolean addStudent(StudentDTO student);
    List<StudentDTO> getStudentList();
    StudentDTO getStudent(int id);

}
