
package com.helloworld.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getStudentListResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getStudentListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentList" type="{com.org.helloworld}studentDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentListResponse", propOrder = {
    "studentList"
})
public class GetStudentListResponse {

    protected List<StudentDTO> studentList;

    /**
     * Gets the value of the studentList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentDTO }
     * 
     * 
     */
    public List<StudentDTO> getStudentList() {
        if (studentList == null) {
            studentList = new ArrayList<StudentDTO>();
        }
        return this.studentList;
    }

}
