package com.tts.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tts.notes.entity.UserInfo;

public interface UserRepository extends JpaRepository <UserInfo,Integer>{
	public UserInfo findByEmail(String email);
}
