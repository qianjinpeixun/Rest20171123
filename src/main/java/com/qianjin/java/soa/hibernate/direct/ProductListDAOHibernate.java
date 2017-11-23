package com.qianjin.java.soa.hibernate.direct;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.qianjin.java.soa.model.ProductList;

public class ProductListDAOHibernate {

	
	private static final Logger logger = Logger.getLogger(ProductListDAOHibernate.class);
	private static ProductListDAOHibernate instance =null;
	private List<ProductList> list ;
	
	private ProductListDAOHibernate(){
		
		Session session = null;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			if (factory == null) {
				logger.error("getSessionFactory factory is null!");
			}

			session = factory.openSession();
			if (session == null) {
				logger.error("openSession is null!");
			}

			list = session.createQuery("from ProductList where visible = 1")
					.list();
			if (list == null) {
				logger.error("list is null");
			} else {
				logger.info("list is not null, size is:"
						+ list.size() + " ,content is:" + list);
			}
		} catch (Exception e) {
			logger.error("get ProductListDAOHibernate with error", e);
		} finally {
			try {
				session.close();
			} catch (Exception e) {
				logger.error("ProductListDAOHibernate close session errors!", e);
			}
		}
		
	}
	
	
	private static synchronized void syncInit(){
		if(instance==null){
			instance=new ProductListDAOHibernate();
		}
	}
	
	public static ProductListDAOHibernate getInstance(){
		if(instance ==null){
			syncInit();
		}
		return instance;
	}
	
	public List<ProductList> getAll(){
		return list;
	}
	
	public void reloadDatabase(){
		ProductListDAOHibernate shadow=new ProductListDAOHibernate();
		list=shadow.getAll();
	}
}
