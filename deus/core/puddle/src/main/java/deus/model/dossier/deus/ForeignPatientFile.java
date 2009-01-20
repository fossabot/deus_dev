package deus.model.dossier.deus;

import java.util.List;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.id.UserId;

/**
 * The FIF in the context of DEUS. The type of the content stored is a list of digital cards.
 * 
 * Abbreviation: FPF
 * 
 * @see DigitalCard
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 * @param <Id>	The id type of the publisher of this FPF.
 */
public class ForeignPatientFile<Id extends UserId> extends ForeignInformationFile<Id, List<DigitalCard<Id>>> {

}
