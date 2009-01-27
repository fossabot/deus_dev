package deus.remoting.state.local;

import deus.model.user.transportid.TransportIdType;
import deus.remoting.state.impl.AbstractRemotingState;

public class LocalRemotingState extends AbstractRemotingState {

	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

}