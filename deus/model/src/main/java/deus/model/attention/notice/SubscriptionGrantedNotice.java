package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class SubscriptionGrantedNotice extends PublisherSentNotice {

	public SubscriptionGrantedNotice(UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	@Override
	public String getCatchphare() {
		//I18N
		return "Your subscription request to "+getPublisherMetadata().getFullName()+" has been granted";
	}


}