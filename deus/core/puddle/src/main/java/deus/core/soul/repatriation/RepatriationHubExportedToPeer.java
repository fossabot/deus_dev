package deus.core.soul.repatriation;

import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;

//FIXME: edit javadoc
public interface RepatriationHubExportedToPeer {

	
	// TODO: add to javadoc: a acknowledgement is sent
	
	/**
	 * This method is used to contribute a digital card to a foreign PIF, i.e. the contributor is not the owner of the
	 * PIF and the contribution is checked by adding an attention element to the barker. Only after the decision to
	 * contribute this digital card is made, it is committed to the PIF.
	 * 
	 * 
	 * @throws IllegalArgumentException if the ID of the user does not match the ID of the CP in the passed digital
	 *             card, or if the ID of the contributor does not match the contributor ID in the passed digital card.
	
	 * 
	 * @param contributedDigitalCard	the digital card to contribute
	 * @param contributorId		the user ID of the contributor
	 */
	public abstract void accept(UserId cpId, DigitalCard contributedDigitalCard, UserId contributorId);

}