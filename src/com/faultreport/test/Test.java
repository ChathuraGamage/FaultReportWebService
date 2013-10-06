package com.faultreport.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.faultreport.om.Report;

public class Test {

	public static void main(String[] args) {
		
		Report report1 = new Report();
		report1.setReportId(2);
		report1.setLocation("L canteen");
		report1.setDescription("Tap is broken");
		report1.setCetegoryId(1);
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
				applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(report1);
		session.getTransaction().commit();

	}

}
