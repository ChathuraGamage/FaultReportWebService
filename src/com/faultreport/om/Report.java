package com.faultreport.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="reports")
public class Report {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int reportId;
	
	@Column (name="place")
	private String location;
	
	@Column (name="description")
	private String description;
	
	@Column (name="category")
	private int cetegoryId;
	
	@Column (name="reporterid")
	private String reporterId;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCetegoryId() {
		return cetegoryId;
	}

	public void setCetegoryId(int cetegoryId) {
		this.cetegoryId = cetegoryId;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

}
