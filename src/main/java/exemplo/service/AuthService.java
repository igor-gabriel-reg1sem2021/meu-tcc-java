package exemplo.service;

import java.net.URI;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;

public class AuthService implements IAuthservice {

	@Override
	public boolean createUser(String email, String password) {
		// TODO Auto-generated method stub
		FirebaseAuth auth = FirebaseAuth.getInstance();
		UserRecord.CreateRequest request = new UserRecord.CreateRequest();
		request.setEmail(email);
		request.setPassword(password);
		try {
			auth.createUser(request);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean login(String email, String password, Set<String> loggedUsers) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		UserRecord.CreateRequest request = new UserRecord.CreateRequest();
		request.setEmail(email);
		request.setPassword(password);
		URI uri = URI.create("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=[API_KEY]");
		UserRecord record = rt.postForEntity(uri, request, UserRecord.class).getBody();
		String uid = record.getUid();
		loggedUsers.add(uid);
		return false;
	}

	@Override
	public void logout(String token, Set<String> loggedUsers) {
		// TODO Auto-generated method stub
		loggedUsers.remove(loggedUsers);

		
		
		
	}
}
