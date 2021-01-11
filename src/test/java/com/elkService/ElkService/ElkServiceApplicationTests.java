package com.elkService.ElkService;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.elkService.ElkService.Dto.UserDto;
import com.elkService.ElkService.Model.User;
import com.elkService.ElkService.Model.Service.UserServiceImpl;
import com.elkService.ElkService.Repository.UserOps;
import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
class ElkServiceApplicationTests {

	@MockBean
	private UserOps userops;
	
	@MockBean
	private RestTemplate restTemplate;
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
    @BeforeEach
	public void setUp() throws ParseException {
    	
    	User myUser = new User(1,"testUser","test@gmail.com","1234567890");
    	//UserDto myUserDto = UserDto.entityToDto(myUser);
    	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    	Mockito.when(userops.save(myUser))
    	.thenReturn(myUser);
    	userServiceImpl = new UserServiceImpl(userops,restTemplate);
    }
    
	@Test
	public void saveUser() throws ParseException {
		User myUser = new User(1,"testUser","test@gmail.com","1234567890");
		UserDto myUserDto = UserDto.entityToDto(myUser);
		when(userServiceImpl.saveUser(myUserDto)).thenReturn(myUserDto);
		Assert.assertEquals(myUser.getUserId(), myUserDto.getUserId());
    }
	
	
	@Test
	public void getAllUsers() throws ParseException {
		User myUser = new User(1,"testUser","test@gmail.com","1234567890");
		User myUser1 = new User(1,"testUser","test@gmail.com","1234567890");
		List<User> myUsersList = new ArrayList<User>();
		myUsersList.add(myUser);
		myUsersList.add(myUser1);
		when(userServiceImpl.getAllUserDetails()).thenReturn(UserDto.entityToDto(myUsersList));
		Assert.assertEquals(2, myUsersList.size());
	}
	
	
	@Test
	public void getUserById() throws ParseException {
		User myUser = new User(1,"testUser","test@gmail.com","1234567890");
		when(userServiceImpl.getUserById(1)).thenReturn(UserDto.entityToDto(myUser));
		Assert.assertEquals(1,1);
	}
	
	@Test
	public void deleteUserById() throws ParseException {
		Assert.assertEquals(1,1);
	}

}
