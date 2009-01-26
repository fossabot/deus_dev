package deus.remoting.commandexecutor.impl;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.commandexecutor.TransportProtocolChoosingStrategy;

/**
 * <code>TransportProtocolChoosingStrategy</code> that always returns the transport id type, that was passed to the
 * constructor. No real choosing is done!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class FixedTransportProtocolChoosingStrategy implements TransportProtocolChoosingStrategy {

	private final TransportIdType transportIdType;


	public FixedTransportProtocolChoosingStrategy(TransportIdType transportIdType) {
		super();
		this.transportIdType = transportIdType;
	}


	@Override
	public TransportIdType choseTransportIdType(UserId userId) {
		return transportIdType;
	}

}
