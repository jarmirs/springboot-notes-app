package com.tts.notes.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tts.notes.entity.UserInfo;
import com.tts.notes.repository.UserRepository;
import com.tts.notes.entity.UserInfo;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserInfo user=userRepo.findByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Exist");
		}else
		{
			CustomUserInfo customUserInfo =new CustomUserInfo(user);
			return customUserInfo;
		}
			
		
	}

}