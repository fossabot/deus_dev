package deus.core.access.transfer.core.soul.protocol.callback;

import deus.core.access.transfer.core.soul.protocol.TransferId;

public interface RegistrationEventCallback {

	public void registered(TransferId transferId);
	
	public void unregistered(TransferId transferId);
	
}
