package com.itp.action1.persistance1;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginClient {
	SessionFactory factory;
	Session ses;
	//private static final Logger log = Logger.getLogger(LoginClient.class.getName());
	

	public LoginClient() 
	{
		//log.info("from constructor");
		
	}

	public RegistrationBean main1(String username) 
	{
		RegistrationBean rb = null;
		Configuration cfg = new Configuration();

		cfg = cfg.configure("com/itp/action1/persistance1/hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();

		ses = factory.openSession();


		Query q = ses
				.createQuery("select rb from RegistrationBean as rb where username ='"
						+ username + "'");

		List l = q.list();
		int i=l.size();
		if(i==0)
		{
			System.out.println("no records found");
		}
		else
		{
		
		/*
		 * for(int i1=0;i1<l.size();i1++) {
		 */
		rb = (RegistrationBean) l.get(0);
		
		//PropertyConfigurator.configure("log4j.properties");
		
		
	//	E:\vaagprojects\EnsuringDataStorageStrutsAndHibernate\src\com\itp\action1\persistance1\log4j.properties
	//	log.debug("Hello this is an debug message");
	     //log.info("Hello this is an info message");

		// }
		//
		ses.close();

		factory.close();
		
		}
		return rb;
	}

	public String registration(RegistrationBean rb) 
	{
		Configuration cfg = new Configuration();

		cfg = cfg.configure("com/itp/action1/persistance1/hibernate.cfg.xml");

		factory = cfg.buildSessionFactory();

		ses = factory.openSession();


		try {

			Transaction tx = ses.beginTransaction();
			System.out.println(rb.getUsername());
			ses.save(rb);

			
			System.out.println("Data Inserted in user_details");

			tx.commit();
			ses.close();
			
		}
		
		catch (Exception exep) 
		{
			exep.printStackTrace();
		}

		return null;

	}

}