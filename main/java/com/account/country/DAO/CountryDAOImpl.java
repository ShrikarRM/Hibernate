package com.account.country.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.account.country.DTO.CountryDTO;

public class CountryDAOImpl implements CountryDAO {
	private StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	public void saveCountry(CountryDTO dto) {

		Session session = null;
		Transaction transaction = null;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
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
	
public void updatePopulationByName(long population, String name) {
	Session session=null;
	Transaction transaction=null;
		try {
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
					
			Query query = session.getNamedQuery("updatePopByCountry");
			query.setParameter("pop",population );
			query.setParameter("nm", name);
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			
		e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	public void deleteCountryNameByCurrency(String currency) {
		Session session = null;
		Transaction transaction = null;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Query query = session.getNamedQuery("deleteByCurrency");
			query.setParameter("cr", currency);
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

	public String getCountryByCurrency(String currency) {
		Session session = null;
		 String name= null;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			SessionFactory sessionFactory = metadata.buildSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("selectQuery");
			query.setParameter("cr", currency);
			name = (String) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}
		return name;
	}

	public List<CountryDTO> getAllCountries() {
		Session session=null;
		List<CountryDTO> countryFromDB=null;
		try {
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
			Metadata metadata=metadataSources.getMetadataBuilder().build();
			SessionFactory sessionFactory =metadata.buildSessionFactory();
			session=sessionFactory.openSession();
			Query query=session.getNamedQuery("selectAllCountriesList");

			countryFromDB=query.list();
			for (CountryDTO countryDTO : countryFromDB) {
				System.out.println(countryDTO);
			}
			 
		} catch (HibernateException e) {
		e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
			if(sessionFactory!=null)
				sessionFactory.close();
		}
				
		return null;
	}

	public CountryDTO getCountryNameCurrency(String currency) {
		Session session = null;
		CountryDTO dto= null;
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			SessionFactory sessionFactory = metadata.buildSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("selectQueryCurrency");
			query.setParameter("cr", currency);
			dto = (CountryDTO) query.uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
			if (sessionFactory != null)
				sessionFactory.close();
		}

		return dto;
	}

	
}
