package deus.core.soul.subscription.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.barker.barker.BarkerExportedToSubsystems;
import deus.model.attention.BinaryDecisionToMake;
import deus.model.attention.Notice;
import deus.model.attention.publication.UpdateNotice;
import deus.model.attention.publication.connection.establish.pubinit.PublisherOffer;
import deus.model.attention.publication.connection.establish.subinit.SubscriptionRequestDeniedNotice;
import deus.model.attention.publication.connection.establish.subinit.SubscriptionRequestGrantedNotice;
import deus.model.attention.publication.connection.terminate.PublisherInitiatedTerminationNotice;
import deus.model.dossier.DigitalCard;
import deus.model.sub.LopEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier("proxy")
public class SubscriberExportedToPeerBarkerProxy implements SubscriberExportedToPeers {

	private final Logger logger = LoggerFactory.getLogger(SubscriberExportedToPeerBarkerProxy.class);

	@Autowired
	@Qualifier("target")
	private SubscriberExportedToPeers proxiedSubscriber;

	@Autowired
	private BarkerExportedToSubsystems barker;

	@Autowired
	private LopEntryDoRep lopEntryDoRep;


	@Override
	public void noticeSubscriptionRequestGranted(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to acknowledgeSubscription");

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestGrantedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestGranted(subscriberId, publisherId);
	}


	@Override
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to denySubscription");

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);

		// get publisher metadata out of LoP
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new SubscriptionRequestDeniedNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
		
		proxiedSubscriber.noticeSubscriptionRequestDenied(subscriberId, publisherId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		logger.debug("proxying call to update");

		proxiedSubscriber.update(subscriberId, publisherId, digitalCard);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		Notice notice = new UpdateNotice(lopEntry.getPublisherMetadata(), digitalCard);
		barker.addUnnoticedAttentionElement(subscriberId, notice);

		logger.debug("added {} to barker", notice);
	}


	@Override
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		logger.debug("proxying call to addPublisher");

		// PLACE PUBLISHER REQUEST
		BinaryDecisionToMake decision = new PublisherOffer(subscriberId, publisherMetadata);
		barker.addUnnoticedAttentionElement(publisherId, decision);
		
		logger.trace("added {} to barker", decision);
	}


	@Override
	public void deletePublisher(UserId subscriberId, UserId publisherId) {
		logger.debug("proxying call to deletePublisher");
		
		// DELETE PUBLISHER
		proxiedSubscriber.deletePublisher(publisherId, subscriberId);

		LopEntry lopEntry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		
		// PLACE NOTICE
		UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		Notice notice = new PublisherInitiatedTerminationNotice(publisherMetadata);
		barker.addUnnoticedAttentionElement(publisherId, notice);
		
		logger.trace("added {} to barker", notice);
	}

}