package es.uji.ei1027.toopots.dao;

import es.uji.ei1027.toopots.domain.UserDetails;

public interface UserDao{
	
	UserDetails loadUserByUsername ( String username, String password);
	
}
