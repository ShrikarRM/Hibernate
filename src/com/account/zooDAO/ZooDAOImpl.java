package com.account.zooDAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.account.zooDTO.ZooDTO;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class ZooDAOImpl implements ZooDAO {
	@Override
	public void saveZoo(ZooDTO zoodto) {

		StandardServiceRegistry standardServiceRegistry;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();

			tx = session.beginTransaction();
			session.save(zoodto);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

	@Override
	public void fetch(String name) {
		SessionFactory sessionFactory = null;
		Session session = null;
		ZooDTO dtoFromHql = null;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			// create the query
			Query query = session.createQuery("select zoo from ZooDTO zoo where zoo.name=:noA");
			query.setParameter("noA", name);
			// "noA" or any parameter can be used in query too
			// processing the query
			dtoFromHql = (ZooDTO) query.uniqueResult();
			System.out.println(dtoFromHql);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

	@Override
	public void deleteRecord(int id) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction;
		ZooDTO del;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Query query = session.createQuery("delete oo from ZooDTO oo where oo.id=:rec");
			query.setParameter("rec", id);
			query.executeUpdate();
			//session.delete(del);
			transaction.commit();
			//System.out.println(del);
		
			
			} catch (HibernateException e) {
			e.printStackTrace();
			} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		
	}

}
