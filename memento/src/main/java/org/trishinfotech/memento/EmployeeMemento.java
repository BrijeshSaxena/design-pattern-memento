package org.trishinfotech.memento;

public class EmployeeMemento {

	protected int empId;
	protected String name;
	protected String designation;
	protected long salary;
	protected String department;
	protected String project;

	public EmployeeMemento(int empId, String name, String designation, long salary, String department, String project) {
		super();
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.department = department;
		this.project = project;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public long getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public String getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "EmployeeMemento [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + ", department=" + department + ", project=" + project + "]";
	}

}
