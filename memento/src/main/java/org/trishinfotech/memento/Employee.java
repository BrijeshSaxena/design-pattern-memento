package org.trishinfotech.memento;

public class Employee {

	protected int empId;
	protected String name;
	protected String designation;
	protected long salary;
	protected String department;
	protected String project;

	public Employee(int empId) {
		super();
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public Employee setDesignation(String designation) {
		this.designation = designation;
		return this;
	}

	public long getSalary() {
		return salary;
	}

	public Employee setSalary(long salary) {
		this.salary = salary;
		return this;
	}

	public String getDepartment() {
		return department;
	}

	public Employee setDepartment(String department) {
		this.department = department;
		return this;
	}

	public String getProject() {
		return project;
	}

	public Employee setProject(String project) {
		this.project = project;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", designation=" + designation + ", salary=" + salary
				+ ", department=" + department + ", project=" + project + "]";
	}

	public EmployeeMemento createMemento() {
		return new EmployeeMemento(empId, name, designation, salary, department, project);
	}

	public void restore(EmployeeMemento memento) {
		if (memento != null) {
			this.empId = memento.empId;
			this.name = memento.name;
			this.designation = memento.designation;
			this.salary = memento.salary;
			this.department = memento.department;
			this.project = memento.project;
		} else {
			System.err.println("Can't restore without memento object!");
		}
	}
}
