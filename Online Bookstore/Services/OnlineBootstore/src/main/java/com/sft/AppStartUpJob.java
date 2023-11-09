package com.sft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sft.dto.UserDTO;
import com.sft.enums.MyRole;
import com.sft.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppStartUpJob implements CommandLineRunner  {
	
	@Autowired
	private UserService userService;
	
	@Value("${admin.email}")
	private String adminEmail;
	
	@Value("${admin.password}")
	private String password;

	@Override
	public void run(String... args) throws Exception {
		if(!userService.isUserExist(adminEmail)) {
			userService.register(new UserDTO(adminEmail, password, MyRole.ADMIN.toString()));
			log.info("Admin created !");
		}else {
			log.info("Admin found !");
		}
	}

}
