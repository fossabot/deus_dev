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
package deus.core.soul.accountadmin.registrator.impl;

import javax.annotation.Resource;
import javax.inject.Named;

import deus.core.soul.accountadmin.registrator.UserIdGenerator;
import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserIdType;
import deus.model.common.user.id.UserUrl;

/**
 * The Class OnlyCreateUserUrlsUserIdGenerator.
 */
@Named("userIdGenerator")
public class OnlyCreateUserUrlsUserIdGenerator implements UserIdGenerator {

	/** The server base url. */
	@Resource(name = "serverBaseUrl")
	private String serverBaseUrl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.accountadmin.registrator.UserIdGenerator#generateUserId
	 * (deus.model.common.user.id.UserIdType, java.lang.String)
	 */
	@Override
	public UserId generateUserId(final UserIdType userIdType,
			final String localUserName) {
		if (!userIdType.equals(UserIdType.url))
			throw new IllegalArgumentException("can only create URLs, not "
					+ userIdType);

		final UserId userId = new UserUrl(localUserName, this.serverBaseUrl);

		return userId;
	}

}
