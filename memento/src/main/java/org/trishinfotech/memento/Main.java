package org.trishinfotech.memento;

public class Main {

	public static void main(String[] args) {
		EmployeeCaretaker caretaker = new EmployeeCaretaker();
		System.out.println("creating employee objects with intial values");
		Employee racheal = new Employee(100).setName("Racheal").setDesignation("Lead").setSalary(100000).setDepartment("R&D").setProject("Transportation Management");
		Employee micheal = new Employee(101).setName("Micheal").setDesignation("Developer").setSalary(75000).setDepartment("Engineering").setProject("IoT");
		System.out.println(racheal);
		System.out.println(micheal);
		EmployeeMemento rachealMemento = racheal.createMemento();
		EmployeeMemento michealMemento = micheal.createMemento();
		caretaker.addMemento(racheal.getEmpId(), "Saved at intitial stage", rachealMemento);
		caretaker.addMemento(micheal.getEmpId(), "Saved at intitial stage", michealMemento);
		System.out.println("\nracheal got promotion");
		racheal.setDesignation("Manager").setSalary(120000);
		System.out.println("micheal assigned to another project.");
		micheal.setProject("Android App");
		System.out.println(racheal);
		System.out.println(micheal);
		rachealMemento = racheal.createMemento();
		michealMemento = micheal.createMemento();
		caretaker.addMemento(racheal.getEmpId(), "Saved at promotion", rachealMemento);
		caretaker.addMemento(micheal.getEmpId(), "Saved at android project", michealMemento);
		System.out.println("\nracheal got increment");
		racheal.setSalary(140000);
		System.out.println("micheal got promotion");
		micheal.setDesignation("Lead Developer").setSalary(90000);
		System.out.println(racheal);
		System.out.println(micheal);
		rachealMemento = racheal.createMemento();
		michealMemento = micheal.createMemento();
		caretaker.addMemento(racheal.getEmpId(), "Saved at increment", rachealMemento);
		caretaker.addMemento(micheal.getEmpId(), "Saved at promotion", michealMemento);
		System.out.println("\nLet's print the stored memento objects we have");
		caretaker.printStoredMementoObjects();
		System.out.println("\nnow for some reason, we like to revert racheal to initial stage.");
		System.out.println("and micheal to android project.");
		rachealMemento = caretaker.getMemento(racheal.getEmpId(), "Saved at intitial stage");
		michealMemento = caretaker.getMemento(micheal.getEmpId(), "Saved at android project");
		racheal.restore(rachealMemento);
		micheal.restore(michealMemento);
		System.out.println(racheal);
		System.out.println(micheal);
	}

}
