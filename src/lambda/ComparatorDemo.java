package lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	static List<Employee> employees; 

	public static void main(String[] args) {
		employees = Utility.getEmployeeList(5);
		
		// ==========  COMPARATOR  =============
		
		System.out.println(" -- Unsorted List --");
		Utility.printEmployeeList(employees);

		System.out.println("\n -- Sorted List : Comparator (ID) --");
		// before JAVA 8		
		EmployeeComparator byID = new EmployeeComparator();
		Collections.sort(employees, byID);

		Utility.printEmployeeList(employees);

		// -----
		
		Comparator<Employee> byAgeAC = new Comparator<Employee>(){

			@Override
			public int compare(Employee e1, Employee e2) {
				int result = e1.getAge() - e2.getAge();
				return result;
			}
			
		};
		
		System.out.println("\n -- Sorted List : Comparator (Age, Lambda) --");
		Comparator<Employee> byAge = (Employee e1, Employee e2) -> e1.getAge() - e2.getAge();
		Comparator<Employee> byAge2 = (e1, e2) -> e1.getAge() - e2.getAge();
		Collections.sort(employees, (Employee e1, Employee e2) -> e1.getAge() - e2.getAge());

		Utility.printEmployeeList(employees);

		// -----
		
		System.out.println("\n -- Sorted List : Comparator.comparing (Lastname) --");
		Comparator<Employee> byLastName = Comparator.comparing(Employee::getLastName);
		Collections.sort(employees, byLastName);
		//Collections.sort(employees, Comparator.comparing(Employee::getLastName));
		
		Utility.printEmployeeList(employees);
		
		// -----

		System.out.println("\n -- Sorted List : Comparator.comparing (Length of lastname) --");
		// to Specify another comparator for that sort key
		// by the length of the last name
		byLastName = Comparator.comparing(Employee::getLastName, (s1, s2) -> s1.length() - s2.length() );
		Collections.sort(employees, byLastName);
		//Collections.sort(employees, Comparator.comparing(Employee::getLastName));
		
		Utility.printEmployeeList(employees);

		
	}
}
