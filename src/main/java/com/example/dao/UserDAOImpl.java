package com.example.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

	private Session session = null;
	private Transaction transaction = null;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User saveOrUpdateUser(User user) {
//		session = this.sessionFactory.openSession();
//		transaction = session.beginTransaction();
		session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
//		transaction.commit();
//		session.close();
		LOGGER.info("User saved successfully, User Details: " + user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
//		session = this.sessionFactory.openSession();
//		transaction = session.beginTransaction();
		session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		for(User user : userList){
			LOGGER.info("User List::"+user);
		}
//		transaction.commit();
//		session.close();
		return userList;
	}

	public User getUserById(int id) {
//		session = this.sessionFactory.openSession();
//		transaction = session.beginTransaction();
		session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, new Integer(id));
//		transaction.commit();
//		session.close();
		LOGGER.info("User loaded successfully, User details: "+ user);
		return user;
	}
}
