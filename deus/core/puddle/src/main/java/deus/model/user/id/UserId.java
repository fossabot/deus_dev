package deus.model.user.id;

import java.util.Collection;

import deus.model.user.transportid.TransportId;
import deus.model.user.transportid.TransportIdType;

public interface UserId {
	
	public int hashCode();
	
	public boolean equals(Object obj);
	
	public UserIdType getType();

	public <T extends TransportId> T getTransportId(Class<T> transportIdType);
	
	public Collection<TransportIdType> getSupportedTransports();

	void addTransportId(TransportId transportId);

	public boolean hasTransportId(TransportIdType transportIdType);
	
}
