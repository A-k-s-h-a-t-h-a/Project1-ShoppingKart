package com.myproject.shoppingcart.daoimpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.shoppingcart.dao.UserDAO;
import com.myproject.shoppingcart.domain.User;

@Transactional
@Repository("userDAO") 
public class UserDAOImpl implements UserDAO{
					
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired
	private User user;
	
	Logger log= LoggerFactory.getLogger(UserDAOImpl.class);
	
	public boolean save(User user) {
	
		log.debug("Starting of the save method");
		try{
			user.setRole("ROLE_USER");
			user.setRegisteredDate(new Date(System.currentTimeMillis()));
			user.setEnabled(true);
			
			sessionFactory.getCurrentSession().save(user);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		log.debug("Starting of the update method");
		try{
			sessionFactory.getCurrentSession().update(user);
			log.debug("Ending of the update method");
		return true;
		} catch (HibernateException e){
			e.printStackTrace();
			log.error("Error occurred in update method"+ e.getMessage());
			return false;
		}
	}

	public User get(String emailId) {
		return sessionFactory.getCurrentSession().get(User.class, emailId);
	}
	
	public User getByName(String name) {
		return sessionFactory.getCurrentSession().get(User.class, name);
	}
	
	public boolean delete(String emailId) {
		log.debug("Starting of the delete method");
		try{
			user= get(emailId);	
			if(user==null){	
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of the delete method");
			return true;
		} 
		catch (HibernateException e){
			e.printStackTrace();
			return false;
		}
	}

	public List<User> list() {
		log.debug("Starting of the list method");
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailId, String password){
		log.debug("Starting of the validate method");
		log.info("user"+ emailId+ "trying to login");
		return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID", emailId)).add(Restrictions.eq("pwd", password)).uniqueResult();
	}
}
