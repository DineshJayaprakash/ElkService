package com.elkService.ElkService.Model.Service;

import java.util.List;
import com.elkService.ElkService.Dto.PatientDto;
import com.elkService.ElkService.Dto.UserDto;

/**
 * interface UserService
 * 
 * @author dinesh
 * @created Date 28/12
 * @description used to define the services availed in endpoint
 *
 */
public interface UserService {
	
	/**
	 * function getAllUserDetails
	 * 
	 * @param none
	 * @return Users Details from Db
	 */
	public List<UserDto> getAllUserDetails();
	
	/**
	 * function getAllPatientDetails
	 * 
	 * @param none
	 * @return Patient Details from Db
	 */
	public List<PatientDto> getAllPatientDetails();
	
	/**
	 * function getUserById
	 * 
	 * @param userid
	 * @return User's Details of mentioned user id
	 */
	public UserDto getUserById(long userid);
	
	/**
	 * function saveUser
	 * 
	 * @param myUser
	 * @return saved user's Details from db
	 */
	public UserDto saveUser(UserDto myUser);
	
	/**
	 * function deleteUser
	 * 
	 * @param userid
	 * @return none
	 */
	public void deleteUser(long userid);
	

}
