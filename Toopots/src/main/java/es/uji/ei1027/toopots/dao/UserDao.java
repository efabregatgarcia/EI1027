package es.uji.ei1027.toopots.dao;

import es.uji.ei1027.NaturAdventure.domain.UserDetails;

public interface UserDao{
	
	UserDetails loadUserByUsername ( String username, String password);
	
}
