package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class UserTest {
	
	public static void main(String[] args) throws ParseException {
		
		testadd();
		
	}

	private static void testadd() throws ParseException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserDTO dto =new UserDTO();
		
		
		dto.setId(2);
		dto.setName("deepak");
		
		dto.setLastname("pandey");
		dto.setUserdate(sdf.parse("1995-02-04"));
		
		UserModel model =new UserModel();
		
		model.add(dto);
		
	}
	
	

}
