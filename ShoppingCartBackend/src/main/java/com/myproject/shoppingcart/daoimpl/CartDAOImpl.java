package com.myproject.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.shoppingcart.dao.CartDAO;
import com.myproject.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {

	@Autowired
	private Cart cart;
	
	@Autowired
	private SessionFactory sessionFactory;

	Logger log= LoggerFactory.getLogger(CartDAOImpl.class);
	
	
	public boolean save(Cart cart) {
		log.debug("Starting of the save method");
		try {
			sessionFactory.getCurrentSession().save(cart);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean update(Cart cart) {
		log.debug("Starting of the update method");
		try {
			cart.getId();
			sessionFactory.getCurrentSession().update(cart);
			
			log.debug("Ending of the update method");
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public Cart get(int ID) {
		return sessionFactory.getCurrentSession().get(Cart.class, ID);
	}


	public Cart get(String pr_id) {
		return sessionFactory.getCurrentSession().get(Cart.class, pr_id);
	}
	
	
	public List<Cart> list(String emailid) {
		log.debug("Starting of the list method");
		return (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("emailID", emailid)).list();
	}

	
	public boolean delete(int id) {
		log.debug("Starting of the delete method");
		try{
			cart= get(id);
			if (cart== null){
				return false;}
			else
			{sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of the delete method");
			return true;}
		} 
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
}
