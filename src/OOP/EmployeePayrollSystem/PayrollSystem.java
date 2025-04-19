package OOP.EmployeePayrollSystem;

import java.util.ArrayList;

class PayrollSystem {
    final private ArrayList<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully...");
    }

    public void removeEmployee(int id) {
        Employee employee = null;
        for (Employee emp: employees) {
            if (emp.getId() == id) {
                employee = emp;
                break;
            }
        }

        if (employee == null) {
            System.out.println("Employee with given id does not exist!");
        } else {
            employees.remove(employee);
            System.out.println("Employee removed successfully...");
        }
    }

    public void displayEmployees() {
        for (Employee employee: employees) {
            System.out.println(employee.toString());
        }
    }
}
