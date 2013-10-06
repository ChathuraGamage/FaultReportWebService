package com.faultreport.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.faultreport.om.Report;

public class Utilities {
	public static void writeLog(String logMessage){
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("E:\\testdata\\test.txt", true)));
		    out.println(logMessage);
		    out.close();
		} catch (IOException e) {
		    //oh noes!
		}
	}
	
	public static void submitReport(){
		Utilities.writeLog("Service called1");
		Utilities.writeLog("user.name" + System.getProperty("user.name"));


		
		try {
			Utilities.writeLog("------------ 1");
			Report report1 = new Report();
			report1.setReportId(3);
			report1.setLocation("GODA canteen");
			report1.setDescription("Tap is broken");
			report1.setCetegoryId(1);
			Utilities.writeLog("------------ 2.1");
			
			/*
			Configuration configuration = null;;
			try {
				Utilities.writeLog("------------ 2.1.1 ");
				configuration = new Configuration();
			} catch (Exception e) {
				Utilities.writeLog("------------ 2.2 Exception occurred");
			}
			
			Utilities.writeLog("------------ 2.5");
			configuration.configure();
			
			Utilities.writeLog("------------ 3");
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
					applySettings(configuration.getProperties()).buildServiceRegistry();
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			*/
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Utilities.writeLog("------------ 4");
			Session session = sessionFactory.openSession();
			
			Utilities.writeLog("------------ 5");
			
			session.beginTransaction();
			session.save(report1);
			session.getTransaction().commit();
			
			session.close();
			sessionFactory.close();
			Utilities.writeLog("------------ 6");
			
		} catch (Exception e) {
			Utilities.writeLog("Exception");
			Utilities.writeLog(e.getMessage());
			Utilities.writeLog(e.getStackTrace().toString());
		}
		
		Utilities.writeLog("Method ends");
	}
	


}
