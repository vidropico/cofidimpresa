package it.cofidimpresa.security;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.cofidimpresa.dao.impl.DefaultProfiloDAO;
import it.cofidimpresa.dao.impl.DefaultUserDAO;
import it.cofidimpresa.datamodel.ProfiloModel;
import it.cofidimpresa.datamodel.UserModel;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Resource(name = "userDAO")
	private DefaultUserDAO userDao;
	
	@Resource(name = "profiloDAO")
	private DefaultProfiloDAO profiloDao;
	
	public UserDetails loadUserByUsername(String j_username) throws UsernameNotFoundException {
		UserModel user = userDao.findByUsername(j_username);
        
		 if(user == null)
	            throw new UsernameNotFoundException("[Login] User : " + j_username + " not found!");
		 
		ProfiloModel profilo = profiloDao.findById(user.getId_profilo());
		user.setRole(profilo.getRole());
		return new MyUserDetails(user);
		        
	}

}
