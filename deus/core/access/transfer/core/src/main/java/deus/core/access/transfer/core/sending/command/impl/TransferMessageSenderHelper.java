package deus.core.access.transfer.core.sending.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.messages.TransferMessage;
import deus.core.access.transfer.core.sending.message.MessageSenderRegistry;
import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;
import deus.model.user.id.UserId;

@Component
public class TransferMessageSenderHelper {

	@Autowired
	private TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;

	@Autowired
	private TransferProtocolRegistry transferProtocolRegistry;

	@Autowired
	private MessageSenderRegistry messageSenderRegistry;


	public void send(UserId receiverId, UserId senderId, TransferMessage transferMessage) {
		// agree on transport protocol
		String transportProtocolId = transferProtocolNegotiationStrategy.negotiateTransportProtocol(receiverId);

		UserIdMapper userIdMapper = transferProtocolRegistry.getRegisteredTransportProtocol(transportProtocolId).getUserIdMapper();
		
		// set IDs of sender and receiver
		transferMessage.setSenderId(senderId);
		transferMessage.setReceiverId(receiverId);
		
		// set TIDs of sender and receiver
		transferMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		transferMessage.setSenderTid(userIdMapper.resolveLocal(senderId));

		// send msg
		MessageSender messageSender = messageSenderRegistry.getMessageSender(transportProtocolId);
		messageSender.send(transferMessage);
	}
}