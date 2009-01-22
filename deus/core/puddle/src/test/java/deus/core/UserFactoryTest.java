package deus.core;


import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.model.attention.AttentionList;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.model.user.id.XmppUserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/model/attention/attentionList.xml", "/deus/storage/daos.xml",
		"/deus/core/user.xml", "/context.xml" })
public class UserFactoryTest {

	@Autowired
	private UserFactory userFactory;

	@Resource(name="attentionList")
	private AttentionList attentionList;
	
	

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testCreateUser() {
		UserId userId = new UserUrl("username", "server");
		User user = userFactory.createUser(userId);
		assertEquals(attentionList, user.barker.getAttentionList());
		// TODO: extend use case
	}

}