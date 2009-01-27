package deus.core.subscriber;

import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;

/**
 * Central facade of the subscriber subsystem.
 * 
 * Methods from the interface <code>RemoteCalledSubscriber</code> are called remotely on this subscriber. The other
 * methods of this interface are methods to retrieve information about the subscriber subsystem locally.
 * 
 * @see RemoteCalledSubscriber
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface Subscriber extends RemoteCalledSubscriber, RemoteCallingSubscriber {

	public DistributedInformationFolder getDistributedInformationFolder();

	public ListOfPublishers getListOfPublishers();
	
	
	public UserMetadata getSubscriberMetadata();


	// FIXME: think about whether we need these two methods
	public void addPublisher(UserMetadata publisherMetadata, SubscriptionState subscriptionState);
	public void removePublisher(UserMetadata publisherMetadata);

}