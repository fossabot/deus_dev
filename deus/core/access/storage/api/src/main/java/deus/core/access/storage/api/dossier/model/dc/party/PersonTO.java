package deus.core.access.storage.api.dossier.model.dc.party;

import java.util.List;
import java.util.UUID;

import deus.model.party.Address;
import deus.model.party.Email;
import deus.model.party.ImAccount;
import deus.model.party.Occupation;
import deus.model.party.Phone;
import deus.model.party.RelatedPerson;
import deus.model.party.WebPresence;
import deus.model.user.id.UserId;

// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
//@Entity
public class PersonTO extends deus.model.party.Person {

	private UUID uuid;

//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public UUID getUuid() {
		return uuid;
	}
		
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
//	@NaturalId
	public UserId getId() {
		return id;
	}


	public void setId(UserId id) {
		this.id = id;
	}
	
	@SuppressWarnings("unchecked")
	public List<Phone> getPhones() {
		return (List<Phone>) phones;
	}

	@SuppressWarnings("unchecked")
	public List<Email> getEmails() {
		return (List<Email>) emails;
	}

	@SuppressWarnings("unchecked")
	public List<WebPresence> getWebPresences() {
		return (List<WebPresence>) webPresences;
	}

	@SuppressWarnings("unchecked")
	public List<ImAccount> getImAccounts() {
		return (List<ImAccount>) imAccounts;
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAddresses() {
		return (List<Address>) addresses;
	}

	@SuppressWarnings("unchecked")
	public List<Occupation> getOccupations() {
		return (List<Occupation>) occupations;
	}

	@SuppressWarnings("unchecked")
	public List<RelatedPerson> getRelatedPersons() {
		return (List<RelatedPerson>) relatedPersons;
	}

}
