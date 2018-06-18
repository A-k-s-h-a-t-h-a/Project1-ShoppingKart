package com.myproject.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.shoppingcart.dao.SupplierDAO;
import com.myproject.shoppingcart.domain.Category;
import com.myproject.shoppingcart.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private Supplier supplier;
	
	Logger log= LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	public boolean save(Supplier supplier) {
		
		log.debug("Starting of the save method");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
			log.debug("Ending of the save method");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		log.debug("Starting of the save method");
		try {
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("Ending of the update method");
			return false;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier get(String supplier_id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, supplier_id);
	}

	public List<Supplier> list() {
		log.debug("Starting and ending of the list method");
		return(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	public boolean delete(String supplier_id) {
		log.debug("Starting of the delete method");
		try{
			supplier= get(supplier_id);
			if (supplier== null){
				return false;
			}
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("Ending of the delete method");
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	}
}
