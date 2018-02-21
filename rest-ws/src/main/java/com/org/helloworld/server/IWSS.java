package com.org.helloworld.server;

import javax.ws.rs.core.Response;

public interface IWSS {

    Response sayHello();
    Response sayHelloTo(String name);
    Response getStudentList();
    Response getStudent(int id);

}
