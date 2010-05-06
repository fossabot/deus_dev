package deus.core.soul.contribution.impl;

import javax.inject.Inject;

import deus.core.access.transfer.core.sending.command.ContributionCommandSender;
import deus.core.soul.contribution.Contributor;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

public class ContributorImpl implements Contributor {

	@Inject
	private ContributionCommandSender contributionCommandSender;
	
	@Override
	public void contributeCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard) {
		contributionCommandSender.forwardToCp(contributorId, repatriationAuthorityId, digitalCard);
	}


	@Override
	public void contributionAcknowledged(ContributorId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to acknowledge the contribution, add a notice to barker)
	}


	@Override
	public void contributionDenied(ContributorId contributorId, DigitalCardId digitalCardId) {
		// FIXME: implement (is called by transfer to tell the denial of the contribution, add a notice to barker)
	}

}