package deus.transport.xmpp.id;

import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.id.TransportId;
import deus.model.user.id.UserId;

public class XmppLocalUserTransportIdFactory implements TransportIdUserIdMapper {

	@Override
	public TransportId map(UserId userId) {
		// FIXME: create XmppTransportId from UserId
		return new XmppTransportId();
	}


	@Override
	public UserId map(TransportId transportId) {
		// FIXME: create UserId from XmppTransportId
		return null;
	}

}