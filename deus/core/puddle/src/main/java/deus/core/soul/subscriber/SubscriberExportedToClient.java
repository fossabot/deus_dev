package deus.core.soul.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Groups methods of the interface <code>Subscriber</code> that trigger remote calls. These methods are implemented
 * using a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>PublisherStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToClient {

	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata);


	public void unsubscribe(UserId subscriberId, UserId publisherId);


	public DistributedInformationFolder getDistributedInformationFolder(UserId subscriberId);


	public ListOfPublishers getListOfPublishers(UserId subscriberId);

}