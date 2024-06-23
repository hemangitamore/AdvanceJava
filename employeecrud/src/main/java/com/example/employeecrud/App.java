package com.example.employeecrud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.employeecrud.employeeDAOImp.EmployeeDAOImpl;
import com.example.employeecrud.model.Employee;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    { 
        Scanner sc = new Scanner(System.in);
        EmployeeDAOImpl employeeDAOImpl = new  EmployeeDAOImpl();
        
        int choice;
        char doNext;
        do {
        	System.out.println("1.Add Employee");
            System.out.println("2.Get All Employee");
            System.out.println("3.Get By Id Employee");
            System.out.println("4.Remove Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            choice  = sc.nextInt();
            if(choice == 1) {
            	Employee employee = new Employee();
            	System.out.print("Enter name of employee: ");
            	sc.nextLine();
            	employee.setName(sc.nextLine());
            	System.out.print("Enter phone of employee: ");
            	employee.setPhone(sc.nextLine());
            	System.out.print("Enter salary of employee: ");
            	employee.setSalary(sc.nextFloat());
            	
            	int id = employeeDAOImpl.save(employee);
            	if(id>0) {
            		System.out.println("Employee (" + id +  ") added successfully!");
            	}else {
            		System.out.println("Something went wrong.");
            	}
            }
            
            else if (choice == 2) {
				List<Employee> emplist =  employeeDAOImpl.getAll();
				if(emplist.size() != 0) {
					Iterator<Employee> itr = emplist.iterator();
					System.out.println("Employe List: ");
					while(itr.hasNext()) {
						Employee employee = itr.next();
					
						System.out.println(employee.toString());
					}
				}else {
					System.out.println("Something went wrong data couldn't be fetched/ Data has no Employee currently");
				}
			}
            
            else if (choice == 3) {
				System.out.print("Enter the employee id you want to search: ");
				int id = sc.nextInt();
				Employee employee = employeeDAOImpl.getById(id);
				if(employee != null) {
					System.out.println("Employee " + id + " details: ");
					System.out.println(employee);
				}else {
					System.out.println("Employee with id (" + id + ") not found");
				}
			}
            
            else if(choice == 4) {
            	System.out.print("Enter the employee id you want to remove: ");
				int id = sc.nextInt();
				int result = employeeDAOImpl.remove(id);
				if(result > 0) {
					System.out.println("Employee with id (" + id + ") removed");
				}else {
					System.out.println("Employee with id (" + id + ") not found/ Something went wrong.");
				}
            }
            else {
            	System.out.println("Menue Exited!!");
            	break;
            }
            System.out.println("Do you want to continue ? (y/n)");
            doNext = sc.next().charAt(0);
            if(doNext == 'n') {
            	System.out.println("Menue Exited!!");
            	break;
            }
		} while (doNext == 'y');
        
        
    }
}
