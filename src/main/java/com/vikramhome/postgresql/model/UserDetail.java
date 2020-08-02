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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user_detail")
@ApiModel(description="All details about the Student. ")
public class UserDetail {
    
	@ApiModelProperty(notes = "The database generated student ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@ApiModelProperty(notes = "The first name")
    @Column(name = "first_name")
    private String firstName;
    
    @ApiModelProperty(notes = "The last name")
    @Column(name = "last_name")
    private String lastName;
    
    @ApiModelProperty(notes = "The user email")
    @Column(name = "email")
    private String email;
    
    @ApiModelProperty(notes = "The user password")
    @Column(name = "password")
    private String password;
    
    @ApiModelProperty(notes = "The user role")
    @Column(name = "role")
    private String role;
    
    public UserDetail() {}

	public UserDetail(String firstName, String lastName, String email, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

    
}