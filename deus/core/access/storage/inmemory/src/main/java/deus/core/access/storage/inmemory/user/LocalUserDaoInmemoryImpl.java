package deus.core.access.storage.inmemory.user;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.user.api.LocalUserDao;
import deus.core.access.storage.api.user.api.UserDao;
import deus.model.user.Account;
import deus.model.user.id.UserId;


@Component("localUserDao")
public class LocalUserDaoInmemoryImpl implements LocalUserDao {

	@Autowired
	UserDao userDao = null;
	
	static HashSet<String> localUsers = new HashSet<String>();
	
	@Override
	public void addNewEntity(UserId userId) {
		userDao.addNewEntity(userId);
		localUsers.add(userId.getUsername());
	}

	@Override
	public void deleteByNaturalId(String naturalId) {
		userDao.deleteByNaturalId(naturalId);
		localUsers.remove(naturalId);
	}

	@Override
	public UserId getByNaturalId(String naturalId) {
		return userDao.getByNaturalId(naturalId);
	}

	@Override
	public void updateEntity(UserId entity) {
		userDao.updateEntity(entity);
	}

	@Override
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsLocalUsername(String localUserName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteAccount(UserId userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

}