/**
 * 
 */
package com.vikramhome.postgresql.model;

/**
 * @author Vikram
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "student")
@ApiModel(description="All details about the Student. ")
public class Student {
    
	@ApiModelProperty(notes = "The database generated student ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@ApiModelProperty(notes = "The student name")
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
	@ApiModelProperty(notes = "The student email")
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

	@ApiModelProperty(notes = "The student phone number")
    @Column(name = "phone_no")
    private long phoneNo;
    
    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
}