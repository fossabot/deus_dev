package deus.core.soul.gatekeeper;

import deus.core.soul.gatekeeper.soul.LoginCredentials;

public interface Gatekeeper {

	public void login(LoginCredentials credentials);


	public void logout(String localUsername);

	
	public void addUserLoginStateObserver(UserLoginStateObserver observer);
	
	public void removeUserLoginStateObserver(UserLoginStateObserver observer);
}