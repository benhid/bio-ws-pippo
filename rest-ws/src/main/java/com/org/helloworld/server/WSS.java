package com.org.helloworld.server;

import com.org.helloworld.bs.StudentBS;
import com.org.helloworld.dto.StudentDTO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationPath("server")
@Path("/school")
@Singleton
public class WSS extends Application implements IWSS{

    /* Endpoint url: http://myHostName/contextPath/servletURI/resourceURI/subresourceURI
       In this case: http://localhost:8080/helloworld-ws/server/school/ */

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
    @GET
    @Path("helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        Response response;

        try {
            response = Response.status(Response.Status.OK).entity("Hello World!").build();
        }
        catch (Exception ex)
        {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @Override
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHelloTo(@PathParam("name") String name) {
        Response response;

        try {
            response = Response.status(Response.Status.OK).entity("Hello "+name).build();
        }
        catch (Exception ex)
        {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @Override
    @GET
    @Path("/get/students")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStudentList() {
        List<StudentDTO> studentList = studentBS.getStudentsList();
        Response response;

        try {
            response = Response.status(Response.Status.OK).entity(
                    new GenericEntity<List<StudentDTO>>(studentList) {}).build();
        }
        catch (Exception ex)
        {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

    @Override
    @GET
    @Path("/get/student/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStudent(@PathParam("id") int id) {
        StudentDTO student = studentBS.getStudent(id);
        Response response;

        try {
            response = Response.status(Response.Status.OK).entity(student).build();
        }
        catch (Exception ex)
        {
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;
    }

}
