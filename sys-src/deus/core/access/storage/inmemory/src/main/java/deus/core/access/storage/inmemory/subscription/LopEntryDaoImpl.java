/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.access.storage.inmemory.subscription;

import javax.inject.Named;

import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.LopEntry;

/**
 * The Class LopEntryDaoImpl.
 * 
 * @author cpn
 */
@Named("lopEntryDao")
public class LopEntryDaoImpl extends
		GenericTwofoldIdDaoImpl<LopEntry, SubscriberId, PublisherId> implements
		LopEntryDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.api.subscription.LopEntryDao#addNewEntity(deus
	 * .model.common.user.frids.SubscriberId, deus.model.subscription.LopEntry)
	 */
	@Override
	public void addNewEntity(final SubscriberId subscriberId,
			final LopEntry entry) {
		this.addNewEntity(subscriberId, entry.getPublisherId(), entry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.access.storage.api.subscription.LopEntryDao#updateEntity(deus
	 * .model.common.user.frids.SubscriberId, deus.model.subscription.LopEntry)
	 */
	@Override
	public void updateEntity(final SubscriberId subscriberId,
			final LopEntry entry) {
		this.updateEntity(subscriberId, entry.getPublisherId(), entry);
	}

}
