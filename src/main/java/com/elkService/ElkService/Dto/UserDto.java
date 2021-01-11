package com.elkService.ElkService.Dto;

import java.util.ArrayList;
import java.util.List;

import com.elkService.ElkService.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	/**
	 * Id of the User
	 */
	private long userId;
	/**
	 * Name of the User
	 */
	private String userName;
	/**
	 * Email of the User
	 */
	private String email;
	/**
	 * mobile of the User
	 */
	private String mobile;
	
	
	public static User dtoToEntity(UserDto dto) {
		
		User userEntity = new User();
		userEntity.setUserId(dto.getUserId());
		userEntity.setUserName(dto.getUserName());
		userEntity.setEmail(dto.getEmail());
		userEntity.setMobile(dto.getMobile());
		return userEntity;
	}
	
	public static UserDto entityToDto(User entity) {
		System.out.println(entity.getUserId() + " " + entity.getEmail() );
		UserDto userdto = new UserDto();
		userdto.setUserId(entity.getUserId());
		userdto.setUserName(entity.getUserName());
		userdto.setEmail(entity.getEmail());
		userdto.setMobile(entity.getMobile());
		return userdto;
	}
	

	public static List<UserDto> entityToDto(List<User> entity) {
		List<UserDto> dto= new ArrayList<>();
		for(int i=0;i<entity.size();i++)
			dto.add(UserDto.entityToDto(entity.get(i)));
		return dto;
	}
	
}
