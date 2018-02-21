package com.org.helloworld.server;

import com.org.helloworld.bs.StudentBS;
import com.org.helloworld.dto.StudentDTO;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "server", targetNamespace = "com.org.helloworld")
@Singleton
public class WSS implements IWSS {

    /* Endpoint url: http://localhost:8080/helloworld-ws/server?wsdl */

    private StudentBS studentBS = new StudentBS();

    @PostConstruct
    public void populate(){
        // Class initializer
        StudentDTO newStudentOne = new StudentDTO();
        newStudentOne.setId(1);
        newStudentOne.setName("Pedro");

        StudentDTO newStudentTwo = new StudentDTO();
        newStudentTwo.setId(2);
        newStudentTwo.setName("Alicia");

        studentBS.addStudent(newStudentOne);
        studentBS.addStudent(newStudentTwo);
    }

    @Override
    @WebMethod
    public String sayHello() {
        return "Hello World!";
    }

    @Override
    @WebMethod
    public boolean addStudent(@WebParam(name="student") StudentDTO student) {
        studentBS.addStudent(student);
        return true;
    }

    @Override
    @WebMethod
    @WebResult(name = "studentList")
    public List<StudentDTO> getStudentList() {
        return studentBS.getStudentsList();
    }

    @Override
    @WebMethod
    @WebResult(name = "student")
    public StudentDTO getStudent(@WebParam(name="id") int id) {
        return studentBS.getStudent(id);
    }

}
