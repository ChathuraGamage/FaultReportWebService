package com.faultreport.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.faultreport.om.Report;
import com.faultreport.test.Utilities;

public class ReportWriter {
	private static String LOCATION_PROPERTY_NAME = "location";
	private static String DESCRIPTION_PROPERTY_NAME = "description";
	private static String CATEGORY_PROPERTY_NAME = "category";
	
	/**.
	 * 
	 * @param content
	 * @return
	 */
	public boolean writeReport(String content){
		
		Report report = generateReport(content);
		
		Session session = null;
		SessionFactory sessionFactory = null;
		try {			
			Configuration configuration = new Configuration();
			configuration.configure();			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
					applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);			
			session = sessionFactory.openSession();						
			session.beginTransaction();
			session.save(report);
			session.getTransaction().commit();			
		} catch (Exception e) {
			if (session != null){
				session.getTransaction().rollback();
			}

			return false;
		}finally{
			if (session != null){
				session.close();
			}
			if (sessionFactory !=null){
				sessionFactory.close();
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param content
	 * @return
	 */
	private Report generateReport(String content){
		String[] keyValuePairs = content.split(";");		
		Report report =  new Report();
		for (String keyValuePair : keyValuePairs) {
			String[] values = keyValuePair.split("=");
			String key = values[0];
			String value = values[1];
			
			if (key.equalsIgnoreCase(LOCATION_PROPERTY_NAME)){
				report.setLocation(value);
			}else if (key.equalsIgnoreCase(DESCRIPTION_PROPERTY_NAME)){
				report.setDescription(value);
			}else if (key.equalsIgnoreCase(CATEGORY_PROPERTY_NAME)){
				report.setCetegoryId(Integer.valueOf(value));
			}
		}
		
		report.setReporterId("user");
		return report;
	}
}

