package com.org.helloworld.client;

import javax.xml.ws.WebServiceRef;
import com.helloworld.ws.Server;
import com.helloworld.ws.StudentDTO;
import com.helloworld.ws.WSS;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class WSC {

    @WebServiceRef
    private static Server service = new Server();

    /* // Alternative:
    private static Service service;
    static {
        try {
            service = Server.create(new URL("http://127.0.0.1:8080/helloworld-ws/server?wsdl"),
                    new QName("com.org.helloworld","server"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    } */

    public static void main(String[] args) {
        try {
            WSC client = new WSC();
            WSS port = service.getWSSPort(); // service.getPort(WSS.class);

            client.sayHello(port);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void sayHello(WSS port) {
        String response = port.sayHello();
        System.out.println(response);
    }

    private void addStudent(WSS port, String name, int id) {
        StudentDTO student = new StudentDTO();
        student.setName(name);
        student.setId(id);

        port.addStudent(student);
    }

    private void getStudent(WSS port, int id) {
        StudentDTO response = port.getStudent(id);
        System.out.println(response.getName());
    }

    private void getStudents(WSS port) {
        List<StudentDTO> response = port.getStudentList();
        System.out.println(Arrays.toString(response.toArray()));
    }

}