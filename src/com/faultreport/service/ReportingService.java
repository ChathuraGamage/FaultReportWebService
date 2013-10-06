package com.faultreport.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.faultreport.om.Report;
import com.faultreport.test.Utilities;

@WebService
public class ReportingService {
	@WebMethod
	public boolean report(String content) {
		return new ReportWriter().writeReport(content);
	}
}
