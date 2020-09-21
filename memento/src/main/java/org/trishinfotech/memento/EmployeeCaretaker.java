package org.trishinfotech.memento;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCaretaker {

	protected Map<Integer, Map<String, EmployeeMemento>> mementoHistory = new HashMap<Integer, Map<String, EmployeeMemento>>();

	public void addMemento(int empId, String mementoMessage, EmployeeMemento memento) {
		if (mementoMessage != null && mementoMessage.trim().length() != 0 && memento != null) {
			Map<String, EmployeeMemento> mementoMessageMap = mementoHistory.get(empId);
			if (mementoMessageMap == null) {
				mementoMessageMap = new HashMap<String, EmployeeMemento>();
				mementoHistory.put(empId, mementoMessageMap);
			}
			mementoMessageMap.put(mementoMessage, memento);
			System.out.printf("Snapshot of employee name '%s' stored with message '%s'.\n", memento.getName(),
					mementoMessage);
		}
	}

	public EmployeeMemento getMemento(int empId, String mementoMessage) {
		EmployeeMemento memento = null;
		if (mementoMessage != null && mementoMessage.trim().length() != 0) {
			Map<String, EmployeeMemento> mementoMessageMap = mementoHistory.get(empId);
			if (mementoMessageMap != null) {
				memento = mementoMessageMap.get(mementoMessage);
				if (memento != null) {
					System.out.printf("Snapshot of employee name '%s' with message '%s' restored\n", memento.getName(),
							mementoMessage);
				} else {
					System.err.println("Not able to find the memento!");
				}
			}
		}
		return memento;
	}

	public void printStoredMementoObjects() {
		System.out.println("======================================================");
		mementoHistory.forEach((empId, mementoMessageMap) -> {
			mementoMessageMap.forEach((message, memento) -> {
				System.out.printf("EmpId: '%d', Message: '%s', Memento: '%s'\n", empId, message, memento);
			});
		});
		System.out.println("======================================================");
	}

}
