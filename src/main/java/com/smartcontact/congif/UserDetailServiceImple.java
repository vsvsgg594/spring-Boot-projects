package com.smartcontact.congif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontact.dao.UserRepository;
import com.smartcontact.entities.User;

public class UserDetailServiceImple implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user1=userRepository.getUserByUserName(username);
		if(user1==null)
		{
			throw new UsernameNotFoundException("could not found user");
		}
		
		UserDetailImp userDetailImple=new UserDetailImp(user1);
		return userDetailImple;
	}

}
