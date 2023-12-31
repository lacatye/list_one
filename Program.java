package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;
public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("How many employees will be registred?: ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ": " );
			System.out.print("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.printf("Salary: ");
			double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id doesn't exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentageIncrease = sc.nextDouble();
			emp.increaseSalary(percentageIncrease);
			
		
		}
		
		System.out.println();
		System.out.println("List of empoloyees: ");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();

	}
	
	// testa se o id existe //
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null; 
	}
}
