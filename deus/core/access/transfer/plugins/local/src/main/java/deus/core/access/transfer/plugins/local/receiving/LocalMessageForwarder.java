package deus.core.access.transfer.plugins.local.receiving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.receiving.message.MessageReceiver;

@Component
public class LocalMessageForwarder {

	@Autowired
	private MessageReceiver messageReceiver;


	public void forward(TransportMessage transportMessage) {
		messageReceiver.receive(transportMessage);
	}

}
