package exemplo.service;

import java.util.Set;

public interface IAuthservice {
	boolean createUser(String email, String password);

	boolean login(String email, String password, Set<String> loggedUsers);

	void logout(String token, Set<String> loggedUsers);

}
