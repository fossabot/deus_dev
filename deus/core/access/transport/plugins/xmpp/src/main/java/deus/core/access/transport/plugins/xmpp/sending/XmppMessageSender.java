package deus.core.access.transport.plugins.xmpp.sending;

import org.jivesoftware.smack.packet.Presence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.connectionstate.ConnectionStateRegistry;
import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.DenySubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.GrantSubscriptionRequestNoticeMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.RequestSubscriptionMessage;
import deus.core.access.transport.core.messages.connection.establishment.subscribe.SubscribeToPublisherMessage;
import deus.core.access.transport.core.messages.connection.termination.UnsubscribeMessage;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.plugins.xmpp.common.XmppConfiguration;
import deus.core.access.transport.plugins.xmpp.common.XmppConversation;
import deus.core.access.transport.plugins.xmpp.connectionstate.XmppConnectionState;
import deus.core.access.transport.plugins.xmpp.core.protocol.XmppTransportId;

@Component
public class XmppMessageSender implements MessageSender {

	@Autowired
	private ConnectionStateRegistry connectionStateRegistry;
	
	@Autowired
	private XmppConfiguration xmppConfiguration;
	
	@Override
	public void send(TransportMessage message) {
		XmppTransportId senderJid = (XmppTransportId)message.getSenderTid();
		XmppTransportId receiverJid = (XmppTransportId)message.getReceiverTid();
		
		XmppConnectionState state = (XmppConnectionState)connectionStateRegistry.getConnectionState(senderJid);
		if(!state.isConnectionEstablished())
			throw new IllegalStateException("XMPP connection is not established!");
		
		
		XmppConversation xmppConversation = state.getXmppConversation();
		
		// USE CASE: SUBSCRIBE
		if(message instanceof SubscribeToPublisherMessage) {
			if(message instanceof RequestSubscriptionMessage) {
				// TODO: implement this method properly
				// Roster roster = subscriberXmppConversation.getRoster();

				// roster.createEntry(publisherJid.toString(), getPublisherMetadata().getFullName(), null);

				Presence presencePacket = new Presence(Presence.Type.subscribe);
				presencePacket.setProperty(xmppConfiguration.getXmppPropertySenderId(), message.getSenderId());
				presencePacket.setProperty(xmppConfiguration.getXmppPropertyReceiverId(), message.getReceiverId());
				xmppConversation.sendPacket(presencePacket, receiverJid);
			}
			else if(message instanceof GrantSubscriptionRequestNoticeMessage) {
				// TODO: implement
			}
			else if(message instanceof DenySubscriptionRequestNoticeMessage) {
				// TODO: implement
			}
			else 
				throw new IllegalArgumentException("cannot handle command " + message);
			
		}
		// USE CASE: UNSUBSCRIBE
		else if(message instanceof UnsubscribeMessage) {
			// TODO: implement this method properly
			// Roster roster = subscriberXmppConversation.getRoster();

			// roster.removeEntry(roster.getEntry(publisherJid.toString()));

			Presence presencePacket = new Presence(Presence.Type.unsubscribe);
			presencePacket.setProperty(xmppConfiguration.getXmppPropertySenderId(), message.getSenderId());
			xmppConversation.sendPacket(presencePacket, receiverJid);
		}
		else {
			throw new IllegalArgumentException("cannot handle message " + message);
		}
	}

}
