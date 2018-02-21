package com.org.helloworld.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="student")
public class StudentDTO {

    private int id;
    private String name;

    public StudentDTO() {}

    public StudentDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}