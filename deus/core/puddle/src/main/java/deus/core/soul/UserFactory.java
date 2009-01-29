package deus.core.soul;

import deus.model.user.id.UserId;


public interface UserFactory {

	/**
	 * Create the user id for the local user with the username <code>username</code>.
	 * 
	 * @param username	the local username of the user, whose id to return
	 * @return		the user id of the user with the given local username
	 */
	public abstract UserId createUserId(String localUsername);


	public abstract User createUser(String localUsername);

}