
package com.helloworld.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para addStudent complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="addStudent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="student" type="{com.org.helloworld}studentDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addStudent", propOrder = {
    "student"
})
public class AddStudent {

    protected StudentDTO student;

    /**
     * Obtiene el valor de la propiedad student.
     * 
     * @return
     *     possible object is
     *     {@link StudentDTO }
     *     
     */
    public StudentDTO getStudent() {
        return student;
    }

    /**
     * Define el valor de la propiedad student.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentDTO }
     *     
     */
    public void setStudent(StudentDTO value) {
        this.student = value;
    }

}
