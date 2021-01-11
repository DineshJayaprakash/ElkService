package com.elkService.ElkService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elkService.ElkService.Dto.PatientDto;
import com.elkService.ElkService.Dto.UserDto;
import com.elkService.ElkService.Model.Service.UserService;


/**
 * class UserController
 * 
 * @author dinesh
 * @created Date 28/12
 * @description used to map the end points to service files
 * 
 *
 */
@RestController
@RequestMapping("users")
public class UserController {
	/**
	 * bean of the userService
	 */
	private final UserService userService;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param userService
	 * @description used to add dependencies
	 */
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * function getallUsers
	 * 
	 * @param none
	 * @Return List Of UserDetails
	 */
	@GetMapping("")
	public List<UserDto> getAllUser() {
		return  userService.getAllUserDetails();
	}
	
	/**
	 * function getallPatients
	 * 
	 * @param none
	 * @Return List Of UserDetails
	 */
	@GetMapping("/patients")
	public List<PatientDto> getPatients() {
		return  userService.getAllPatientDetails();
	}
	
	/**
	 * function getUserByID
	 * 
	 * @param id
	 * @return used to get the user's details based on ID
	 */
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable long id) {
		return  userService.getUserById(id);
	}
	
	/**
	 * function saveUser
	 * 
	 * @param myUser
	 * @return saved UserDetails
	 */
	@PostMapping("")
	public UserDto saveUser(@RequestBody UserDto myUser) {
		return userService.saveUser(myUser);
	}
	
	/**
	 * function deleteUserById
	 * 
	 * @param id
	 * @return none
	 * @description used delete the users based on userId
	 */
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable long id) {
		userService.deleteUser(id);
	}

}
