package com.example.leave.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="LeaveSystem")
public class Leave {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "emp_name")
	private String empname;
	

	@Column(name = "dept_name")
	private String deptname;
	
	
	@Column(name = "leave_type")
	private String leavetype;
	
	
	@Column(name = "from_date")
	private String fromdate;
	

	@Column(name = "to_date")
	private String todate;
	

	@Column(name = "reason")
	private String reason;

	public int getId() {
		return id;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getReason() {
		return reason;
	}
	

	public void setReason(String reason) {
		this.reason = reason;
	}

}
