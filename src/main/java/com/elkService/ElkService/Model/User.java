package com.elkService.ElkService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class User
 * 
 * @author dinesh
 * @created Date 28/12
 * @description used for the db related operations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="userdetails")
public class User {

	/**
	 * Id of the User
	 */
	@Id
	@Column(name="userId")
	private long userId;
	/**
	 * Name of the User
	 */
	@Column(name="userName")
	private String userName;
	/**
	 * Email of the User
	 */
	@Column(name="email")
	private String email;
	/**
	 * mobile of the User
	 */
	@Column(name="mobile")
	private String mobile;
}
