package com.account.dao;

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

import com.account.dto.OotaDTO;
import com.account.hibernate.HibernateSingleton;

public class OotaDAOImpl implements OotaDAO {
	private StandardServiceRegistry standardServiceRegistry;

	SessionFactory sessionFactory = null;
	Session session = null;

	/*public void saveOota(OotaDTO dto) {
		try {
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
			Metadata metadata = metadataSources.getMetadataBuilder().build();
			SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
			Session session = sessionFactory.openSession();

			Transaction transaction = session.beginTransaction();
			session.save(dto);
			transaction.commit();

		} catch (HibernateException e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (sessionFactory != null) {
			sessionFactory.close();
		}

	}*/
	
	//by invoking singleTon
	public void saveDetails(OotaDTO dto){
		try{
			session=HibernateSingleton.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(dto);
			session.getTransaction().commit();
			
		}catch (HibernateException e){
				e.printStackTrace();
		}
		if(session!=null){
			session.close();
		}if(sessionFactory!=null){
			sessionFactory.close();
		}
	}
	

	/*@Override
	public List<OotaDTO> getOota(OotaDTO dto) {

		SessionFactory sessionFactory=null;
		Session session=null;
		List<OotaDTO> ootaDTO=null;
		try{
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
			Metadata metadata=metadataSources.getMetadataBuilder().build();
			sessionFactory=metadata.getSessionFactoryBuilder().build();
			session=sessionFactory.openSession();
			
			Query query=session.createQuery("from OotaDTO dto");
			ootaDTO=(List<OotaDTO>)query.list();
			for(OotaDTO ootaDTO2:ootaDTO){
				System.out.println(ootaDTO2);
			}
		}
			catch (HibernateException e) {
				e.printStackTrace();
			}
		finally{
			if(session!=null)
				session.close();
			if(sessionFactory!=null)
				sessionFactory.close();
		}
		return ootaDTO;
	}
	
	@Override
	public List<OotaDTO> getOota(String name) {
		List<OotaDTO> ootaDTO=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		//OotaDTO ootaDTO=null;
		Transaction transaction=null;
		try{
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
			Metadata metadata=metadataSources.getMetadataBuilder().build();
			sessionFactory=metadata.getSessionFactoryBuilder().build();
			session=sessionFactory.openSession();
			//preparing the Query
			Query query=session.createQuery("from OotaDTO dto");
			//Process the Query
			ootaDTO=query.list();
			System.out.println(ootaDTO);
		}
		catch(HibernateException e){
			if(transaction!=null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		return ootaDTO;
	}
	
	@Override
	public Object[] getOotaPlaceByName(String name) {
			SessionFactory sessionFactory=null;
			Session session=null;
			Object[] place=null;
			try{
				StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
				Metadata metadata=metadataSources.getMetadataBuilder().build();
				sessionFactory=metadata.getSessionFactoryBuilder().build();
				session=sessionFactory.openSession();
				//preparing the Query
				Query query=session.createQuery("select oo.place, oo.type from OotaDTO oo where oo.name='"+name+"'");
				//Process the Query
				place=(Object[])query.uniqueResult();
				for (Object object : place) {
					System.out.println(object);
				}
			}
			catch(HibernateException e){
				e.printStackTrace();
			}finally{
				if(session!=null){
					session.close();
				}if(sessionFactory!=null){
					sessionFactory.close();
				}
			}
			return place;
		}


	@Override
	public List<Object[]> getOotaPlaceByName() {
			SessionFactory sessionFactory=null;
			Session session=null;
			List<Object[]> place=null;
			try{
				StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
				Metadata metadata=metadataSources.getMetadataBuilder().build();
				sessionFactory=metadata.getSessionFactoryBuilder().build();
				session=sessionFactory.openSession();
				//preparing the Query
				Query query=session.createQuery("select oo.place, oo.type from OotaDTO oo");
				//Process the Query
				place=query.list();
				for (Object[] objects : place) {
					for (Object object : objects) {
						System.out.println(object);
					}
				}
			}
			catch(HibernateException e){
				e.printStackTrace();
			}finally{
				if(session!=null){
					session.close();
				}if(sessionFactory!=null){
					sessionFactory.close();
				}
			}
			return place;
		}
*/
	@Override
	public String updateTable(String name) {
		SessionFactory sessionFactory=null;
		Session session=null;
		OotaDTO ootaDTO=null;
		try{
			StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSources=new MetadataSources(standardServiceRegistry);
			Metadata metadata=metadataSources.getMetadataBuilder().build();
			sessionFactory=metadata.getSessionFactoryBuilder().build();
			session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			//preparing the Query
			Query query=session.createQuery("update OotaDTO set type='north' where name='Roti'");
			//Process the Query
			query.executeUpdate();
			//System.out.println(ootaDTO);
		}
		catch(HibernateException e){
			
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		
		return name;
	}
	
}
