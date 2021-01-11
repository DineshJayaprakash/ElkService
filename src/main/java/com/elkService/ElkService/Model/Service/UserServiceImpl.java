package com.elkService.ElkService.Model.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.elkService.ElkService.Dto.PatientDto;
import com.elkService.ElkService.Dto.UserDto;
import com.elkService.ElkService.Model.User;
import com.elkService.ElkService.Repository.UserOps;
import org.slf4j.Logger;


/**
 * class UserServiceImpl
 * 
 * @author dines
 * @Created Date 28/12
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	private static final String HttpMethod = null;

	private final UserOps userOps;
	
	private final RestTemplate restTemplate;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserServiceImpl(UserOps userOps,RestTemplate restTemplate) {
		this.userOps = userOps;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<UserDto> getAllUserDetails() {
		logger.info("UserDetails List gets published");
		return UserDto.entityToDto(userOps.findAll());
	}

	@Override
	public UserDto getUserById(long userid) {
		logger.info("User Details found based on id"+ userid);
		return UserDto.entityToDto(userOps.findByUserId(userid));
	}

	@Override
	public UserDto saveUser(UserDto myUser) {
        logger.info("saved UserDetails"+ myUser);
		return UserDto.entityToDto(userOps.save(UserDto.dtoToEntity(myUser)));
	}

	@Override
	public void deleteUser(long userid) {
		userOps.deleteById(userid);
		logger.info("Record gets Deleted for reference id of user " + userid);
	}

	@Override
	public List<PatientDto> getAllPatientDetails() {
		
		ResponseEntity<List<PatientDto>> responseEntity =
				restTemplate.exchange("http://localhost:9193/patients",
						org.springframework.http.HttpMethod.GET, null, new ParameterizedTypeReference<List<PatientDto>>() {
				});
		List<PatientDto> listOfString = responseEntity.getBody();
		return listOfString;
	}

}
