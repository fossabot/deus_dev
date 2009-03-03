package deus.core.soul.contributor;

import deus.model.dossier.DigitalCardId;
import deus.model.user.id.UserId;

public interface ContributorExportedToPeer {

	public void acknowledgeContribution(UserId contributorId, DigitalCardId digitalCardId);
	
	public void denyContribution(UserId contributorId, DigitalCardId digitalCardId);
	
}