package cn.aceo.smis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.aceo.smis.dao.IUserDAO;
import cn.aceo.smis.dao.impl.UserDAOImpl;
import cn.aceo.smis.domain.User;

public class UserDAOTest {
	IUserDAO userDAO=new UserDAOImpl();
	@Test
	public void testSave() {
		User user=new User();
		user.setName("金毛狮王");
		user.setAge(56);
		userDAO.save(user);
	}

	@Test
	public void testDelete() {
		userDAO.delete(10L);
	}

	@Test
	public void testUpdate() {
		User newUser=new User();
		newUser.setName("刘光第");
		newUser.setAge(22);
		userDAO.update(10L, newUser);
	}

	@Test
	public void testGet() {
		
		User user=userDAO.get(10L);
		System.out.println(user);
	}

	@Test
	public void testListAll() {
		List<User> users=userDAO.listAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
