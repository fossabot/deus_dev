package deus.gatekeeper.registrator;

import deus.model.user.id.UserId;

public interface UserRegistrationStateObserver {
	
	public void registered(UserId userId);
	
	public void unregistered(UserId userId);

}
